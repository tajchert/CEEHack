package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.android.ceehack.trust.R;
import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;

public class ChartBarCards extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());

	protected BarGraph g;
	
	public ChartBarCards(Context context) {
		this(context, R.layout.cards_chart_bar_main);
	}

	public ChartBarCards(Context context, int innerLayout) {
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
		ArrayList<Bar> points = new ArrayList<Bar>();
		Bar d = new Bar();
		d.setColor(Color.parseColor("#99CC00"));
		d.setName("Test1");
		d.setValue(10);
		Bar d2 = new Bar();
		d2.setColor(Color.parseColor("#FFBB33"));
		d2.setName("Test2");
		d2.setValue(20);
		points.add(d);
		points.add(d2);

		g = (BarGraph)view.findViewById(R.id.graphHorizontal);
		g.setBars(points);
	}
}
