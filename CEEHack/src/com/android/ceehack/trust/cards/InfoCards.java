package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;

import java.text.SimpleDateFormat;
import java.util.Set;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ceehack.trust.ActivityParty;
import com.android.ceehack.trust.R;
import com.android.ceehack.trust.ui.MainSelectorActivity;

public class InfoCards extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());
	protected ImageView indicator;
	protected TextView date;
	protected TextView text;
	private Context context;
	
	public InfoCards(Context context) {
		this(context, R.layout.cards_info_main);
		
	}

	public InfoCards(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context = context;
		init();
	}

	private void init() {
		
		// No Header

		setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
            	Intent myIntentParty = new Intent(context, ActivityParty.class);
        		//myIntent.putExtra("key", value); //Optional parameters
            	context.startActivity(myIntentParty);
            }
        });
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		
		indicator = (ImageView) view.findViewById(R.id.imageViewColorIndicator);
		date = (TextView) view.findViewById(R.id.textViewDate);
		text = (TextView) view.findViewById(R.id.textViewContent);
		
		if(indicator != null){
			indicator.setBackgroundColor(Color.parseColor("#30B643"));
			//indicator.setBackgroundColor(Color.parseColor("#EF4604"));
		}

	}
}
