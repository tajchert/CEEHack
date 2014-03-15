package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.android.ceehack.trust.R;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;

public class ChartPieCard extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());

	protected PieGraph pg;
	
	public ChartPieCard(Context context) {
		this(context, R.layout.cards_chart_main);
	}

	public ChartPieCard(Context context, int innerLayout) {
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
		pg = (PieGraph)view.findViewById(R.id.graph);
		PieSlice slice = new PieSlice();
		slice.setColor(Color.parseColor("#99CC00"));
		slice.setValue(2);
		pg.addSlice(slice);
		slice = new PieSlice();
		slice.setColor(Color.parseColor("#FFBB33"));
		slice.setValue(3);
		pg.addSlice(slice);
		slice = new PieSlice();
		slice.setColor(Color.parseColor("#AA66CC"));
		slice.setValue(8);
		pg.addSlice(slice);

	}
}
