package com.android.ceehack.trust.data;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.ceehack.trust.Application;

import android.annotation.SuppressLint;
import android.util.Log;

public class JsonParser {
	private String urlString = "https://raw.github.com/tajchert/CEEHack/master/data/promises/po.json";

	public volatile boolean parsingComplete = true;
	//private Context co

	public JsonParser(String url) {
		this.urlString = url;
	}

	@SuppressLint("NewApi")
	public void readAndParseJSON(String in) {
		try {
			String tmp = "{\"sys\":";
			in = tmp+ in + "}";
			JSONObject reader = new JSONObject(in);
			Log.d("TAG_haha", "Call");
			JSONArray sys = reader.getJSONArray("sys");
			//ArrayList<JsonObjResult> listaPostow = new ArrayList<JsonObjResult>();
			Application.listaPostow = new ArrayList<JsonObjResult>();
			for (int i=0; i<sys.length(); i++) {
				JsonObjResult tmpT = new JsonObjResult();
				
				 JSONObject a2 = sys.getJSONObject(i);
				 tmpT.setBrief(a2.getString("brief"));
				 tmpT.setFull(a2.getString("full"));
				 tmpT.setStatus(a2.getString("status"));
				 tmpT.setDue_date(a2.getString("due_date"));
				 Application.listaPostow.add(tmpT);
				}
			
			for(JsonObjResult obj: Application.listaPostow){
				Log.d("TAG_haha", obj.getBrief() + "!!!");
			}
			//sys.getString("")
			//Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show();

			parsingComplete = false;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fetchJSON() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					URL url = new URL(urlString);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setReadTimeout(10000 /* milliseconds */);
					conn.setConnectTimeout(15000 /* milliseconds */);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					// Starts the query
					conn.connect();
					InputStream stream = conn.getInputStream();

					String data = convertStreamToString(stream);

					readAndParseJSON(data);
					stream.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}
}