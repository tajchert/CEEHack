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
	private final int pxHeight = 120;
	private final int pxWidth = 400;
	private Bitmap bm;
	private Canvas cav;
	private Paint paint;
	private ImageView imV;

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

		int mainGray = 77;
		int mainRed = 45;
		int mainGreen = 23;

		int SmallHeight = 30;
		int SmallWidth = 30;

		Bitmap bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight,
				Bitmap.Config.ARGB_8888);
		Canvas cavIO = new Canvas(bmIO);
		Paint paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#30B643"));
		RectF rectF = new RectF(0, 0, 30, 30);
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIO = (ImageView) view.findViewById(R.id.FirstIcon);
		imVIO.setImageBitmap(bmIO);

		bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight,
				Bitmap.Config.ARGB_8888);
		cavIO = new Canvas(bmIO);
		paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#EF4604"));
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIS = (ImageView) view.findViewById(R.id.SecIcon);
		imVIS.setImageBitmap(bmIO);

		bmIO = Bitmap.createBitmap(SmallWidth, SmallHeight,
				Bitmap.Config.ARGB_8888);
		cavIO = new Canvas(bmIO);
		paintIO = new Paint();
		paintIO.setColor(Color.parseColor("#7E7E7E"));
		cavIO.drawOval(rectF, paintIO);
		ImageView imVIT = (ImageView) view.findViewById(R.id.ThreeIcon);
		imVIT.setImageBitmap(bmIO);

		TextView txThree = (TextView) view.findViewById(R.id.titleThree);
		txThree.setText(green + "%");
		TextView txTwo = (TextView) view.findViewById(R.id.titleTwo);
		txTwo.setText(red + "%");
		TextView txOne = (TextView) view.findViewById(R.id.titleOne);
		txOne.setText(gray + "%");
		// LOW SECTION
		TextView LowtxThree = (TextView) view.findViewById(R.id.LowtitleThree);
		LowtxThree.setText(mainGreen + "%");
		TextView LowtxTwo = (TextView) view.findViewById(R.id.LowtitleTwo);
		LowtxTwo.setText(mainRed + "%");
		TextView LowtxOne = (TextView) view.findViewById(R.id.LowtitleOne);
		LowtxOne.setText(mainGray + "%");

		gray = (gray * pxWidth) / 100;
		red = (red * pxWidth) / 100;
		green = (green * pxWidth) / 100;
		
		mainGray = (mainGray * pxWidth) / 100;
		mainRed = (mainRed * pxWidth) / 100;
		mainGreen = (mainGreen * pxWidth) / 100;
		
		setBarChart(view, R.id.barTop, gray, Color.parseColor("#7E7E7E"));

		setBarChart(view, R.id.barSec, red, Color.parseColor("#EF4604"));

		setBarChart(view, R.id.barThree, green, Color.parseColor("#30B643"));

		setBarChart(view, R.id.LowbarTop, mainGray, Color.parseColor("#7E7E7E"));

		setBarChart(view, R.id.LowbarSec, mainRed, Color.parseColor("#EF4604"));

		setBarChart(view, R.id.LowbarThree, mainGreen,
				Color.parseColor("#30B643"));

	}

	private void setBarChart(View view, int idBar, int percentage, int colore) {
		bm = Bitmap.createBitmap(pxWidth, pxHeight, Bitmap.Config.ARGB_8888);
		cav = new Canvas(bm);
		paint = new Paint();
		paint.setColor(Color.parseColor("#E9E9E9"));
		cav.drawRoundRect(new RectF(0, 0, pxWidth, pxHeight), 7, 7, paint);
		paint.setColor(colore);
		cav.drawRoundRect(new RectF(0, 0, percentage, pxHeight), 7, 7, paint);
		imV = (ImageView) view.findViewById(idBar);

		imV.setImageBitmap(bm);
	}
}
