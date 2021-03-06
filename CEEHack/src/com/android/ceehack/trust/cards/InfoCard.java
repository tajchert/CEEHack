package com.android.ceehack.trust.cards;

import it.gmariotti.cardslib.library.internal.Card;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ceehack.trust.ActivityDetail;
import com.android.ceehack.trust.R;

public class InfoCard extends Card {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",
			java.util.Locale.getDefault());
	protected ImageView indicator;
	protected TextView date;
	protected TextView text;
	private Context context;
	public String type = "fulfilled";
	public int num = 0;
	public String content  = "";
	public String dateContent;

	public InfoCard(Context context) {
		this(context, R.layout.cards_info_main);

	}

	public InfoCard(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context = context;
		init();
	}

	private void init() {

		// No Header

		setOnClickListener(new OnCardClickListener() {
			@Override
			public void onClick(Card card, View view) {
				Intent myIntentParty = new Intent(context, ActivityDetail.class);
				myIntentParty.putExtra("number", num); //Optional parameters
				context.startActivity(myIntentParty);
			}
		});
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		indicator = (ImageView) view.findViewById(R.id.imageViewColorIndicator);
		date = (TextView) view.findViewById(R.id.textViewDate);
		text = (TextView) view.findViewById(R.id.textViewContent);
		date.setText(dateContent +"");
		if(content.length()> 38){
			content = content.substring(0, 38)+"...";
		}
		
		if (content != null) {
			text.setText(content);
		}

		if (indicator != null) {
			if (type.equals("fulfilled")) {
				indicator.setBackgroundColor(Color.parseColor("#30B643"));
			} else if (type.equals("broken")) {
				indicator.setBackgroundColor(Color.parseColor("#EF4604"));
			}
		}

	}
}
