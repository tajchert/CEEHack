package com.android.ceehack.trust.ui;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.ceehack.trust.ActivityParty;
import com.android.ceehack.trust.R;
import com.android.ceehack.trust.data.JsonParser;

public class ActivityPartySelector extends Activity {
	private ListView mainListView;
	private ArrayAdapter<String> listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_selector);
		
		
		
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(7, 152, 227)));
		
		LinearLayout ly = (LinearLayout) findViewById(R.id.mainLay);
		ly.setBackgroundColor(Color.rgb(0, 88, 133));

		// Find the ListView resource.
		mainListView = (ListView) findViewById(R.id.mainListView);
		String[] planets = new String[] { "Platforma Obywatelska", "Prawo i Sprawiedliwość", "Polskie Stronnictwo Ludowe", 
				"Sojusz Lewicy Demokratycznej", "Solidarna Polska", "Polska Razem", "Socjaldemokracja Polska", "Unia Pracy" };
		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll(Arrays.asList(planets));
		listAdapter = new ArrayAdapter<String>(this,
				R.layout.list_view_row_main_page, planetList);
		mainListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
				String value = (String) adapter.getItemAtPosition(position);
				switch (position) {
				case 0:
					Intent myIntentParty = new Intent(ActivityPartySelector.this, ActivityParty.class);
					//myIntent.putExtra("key", value); //Optional parameters
					ActivityPartySelector.this.startActivity(myIntentParty);
					break;
				case 1:
					break;
				case 2:
					break;
				default:
					break;
				}

			}
		});
		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter(listAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_selector, menu);
		return true;
	}

}
