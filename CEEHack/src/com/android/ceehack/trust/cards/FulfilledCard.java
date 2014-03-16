package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.ceehack.trust.R;

public class FulfilledCard extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());
	protected ImageView indicatorYes;
	protected ImageView indicatorNo;
	
	public FulfilledCard(Context context) {
		this(context, R.layout.cards_fulfiled_main);
	}

	public FulfilledCard(Context context, int innerLayout) {
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
		
		indicatorYes = (ImageView) view.findViewById(R.id.imageViewYes);
		indicatorNo = (ImageView) view.findViewById(R.id.imageViewNo);
		if(indicatorYes != null){
			indicatorYes.setBackgroundColor(Color.parseColor("#30B643"));
			indicatorNo.setBackgroundColor(Color.parseColor("#EF4604"));
			//indicator.setBackgroundColor(Color.parseColor("#EF4604"));
		}

	}
}
