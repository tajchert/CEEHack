package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ceehack.trust.R;
import com.echo.holographlibrary.BarGraph;

public class DetailPartyChart extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());

	protected BarGraph g;
	
	public DetailPartyChart(Context context) {
		this(context, R.layout.cards_chart_bar_detail);
	}

	public DetailPartyChart(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init() {

		// No Header

		/*
		 * //Set a OnClickListener listener setOnClickListener(new
		 * OnCardClickListener() {
		 * 
		 * @Override public void onClick(Card card, View view) {
		 * Toast.makeText(getContext(), "Click Listener card=",
		 * Toast.LENGTH_LONG).show(); } });
		 */
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		int gray = 37;
		int red = 23;
		int green = 45;
		
		int SmallHeight = 30;
		int SmallWidth = 30;
		
		Bitmap bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight, Bitmap.Config.ARGB_8888);
		Canvas cavIO = new Canvas(bmIO);
		Paint paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#30B643"));
		RectF rectF = new RectF(0, 0, 30, 30);
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIO = (ImageView) view.findViewById(R.id.FirstIcon);
		imVIO.setImageBitmap(bmIO);
		
		bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight, Bitmap.Config.ARGB_8888);
		cavIO = new Canvas(bmIO);
		paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#EF4604"));
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIS = (ImageView) view.findViewById(R.id.SecIcon);
		imVIS.setImageBitmap(bmIO);
		
		bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight, Bitmap.Config.ARGB_8888);
		cavIO = new Canvas(bmIO);
		paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#7E7E7E"));
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIT = (ImageView) view.findViewById(R.id.ThreeIcon);
		imVIT.setImageBitmap(bmIO);
		
		
		
		TextView txThree = (TextView) view.findViewById(R.id.titleThree);
		txThree.setText(green+"%");
		TextView txTwo = (TextView) view.findViewById(R.id.titleTwo);
		txTwo.setText(red+"%");
		TextView txOne = (TextView) view.findViewById(R.id.titleOne);
		txOne.setText(gray+"%");
		
		int pxHeight = 120;
		int pxWidth = 400;
		
		gray = (gray *pxWidth)/100;
		red = (red *pxWidth)/100;
		green = (green *pxWidth)/100;
		
		Bitmap bm = Bitmap.createBitmap(pxWidth, pxHeight, Bitmap.Config.ARGB_8888);
		Canvas cav = new Canvas(bm);
		Paint paint = new Paint();
		 //paint.setAlpha(0);
         //paint.setAntiAlias(true);
		//cav.drawColor(Color.GRAY);
		paint.setColor(Color.parseColor("#E9E9E9"));
		cav.drawRoundRect(new RectF(0, 0, pxWidth, pxHeight), 7, 7, paint);
		paint.setColor(Color.parseColor("#7E7E7E"));
		cav.drawRoundRect(new RectF(0, 0, gray, pxHeight), 7, 7, paint);
		ImageView imV = (ImageView) view.findViewById(R.id.barTop);
		
		imV.setImageBitmap(bm);
		
		
		Bitmap bmS = Bitmap.createBitmap(pxWidth, pxHeight, Bitmap.Config.ARGB_8888);
		Canvas cavS = new Canvas(bmS);
		Paint paintS = new Paint();
		paintS.setColor(Color.parseColor("#E9E9E9"));
		cavS.drawRoundRect(new RectF(0, 0, pxWidth, pxHeight), 7, 7, paintS);
		paintS.setColor(Color.parseColor("#EF4604"));
		cavS.drawRoundRect(new RectF(0, 0, red, pxHeight), 7, 7, paintS);
		
		ImageView imVS = (ImageView) view.findViewById(R.id.barSec);
		
		imVS.setImageBitmap(bmS);
		
		
		Bitmap bmT = Bitmap.createBitmap(pxWidth, pxHeight, Bitmap.Config.ARGB_8888);
		Canvas cavT = new Canvas(bmT);
		Paint paintT = new Paint();
		 //paint.setAlpha(0);
         //paint.setAntiAlias(true);
		//cav.drawColor(Color.GRAY);
		paintT.setColor(Color.parseColor("#E9E9E9"));
		cavT.drawRoundRect(new RectF(0, 0, pxWidth, pxHeight), 7, 7, paintT);
		paintT.setColor(Color.parseColor("#30B643"));
		//cav.drawColor(Color.RED);
		cavT.drawRoundRect(new RectF(0, 0, green, pxHeight), 7, 7, paintT);
		
		ImageView imVTwo = (ImageView) view.findViewById(R.id.barThree);
		
		imVTwo.setImageBitmap(bmT);
		
		
		/*ArrayList<Bar> points = new ArrayList<Bar>();
		Bar d = new Bar();
		d.setColor(Color.parseColor("#99CC00"));
		d.setName("");
		d.setValue(10);
		Bar d2 = new Bar();
		d2.setColor(Color.parseColor("#FFBB33"));
		d2.setName("");
		d2.setValue(20);
		points.add(d);
		points.add(d2);

		g = (BarGraph)view.findViewById(R.id.graphHorizontal);
		g.setBars(points);*/
	}
}
