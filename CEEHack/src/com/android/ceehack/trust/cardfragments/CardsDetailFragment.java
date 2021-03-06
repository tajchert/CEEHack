package com.android.ceehack.trust.cardfragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.ceehack.trust.Application;
import com.android.ceehack.trust.R;
import com.android.ceehack.trust.cards.ChartBarCards;
import com.android.ceehack.trust.cards.DetailPartyChart;
import com.android.ceehack.trust.cards.FulfilledCard;
import com.android.ceehack.trust.cards.InfoCard;
import com.android.ceehack.trust.cards.InfoLongCard;
import com.android.ceehack.trust.cards.ProofCard;
import com.android.ceehack.trust.data.JsonObjResult;


public class CardsDetailFragment extends Fragment {
	int number;
	JsonObjResult tmp;
	public CardsDetailFragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.cards_fragment_info, container,false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(7, 152, 227)));

		LinearLayout ly = (LinearLayout) getActivity().findViewById(R.id.mainLay);
		ly.setBackgroundColor(Color.parseColor("#232323"));
        
		Intent myIntent = getActivity().getIntent(); // gets the previously created intent
		number = myIntent.getIntExtra("number", 0);
		tmp = Application.listaPostow.get(number);
		initCards();
	}

	private void initCards() {

		// Init an array of Cards
		ArrayList<Card> cardsChart = new ArrayList<Card>();
		Card card = init_info_card(tmp.getFull(), tmp.getStatus(), tmp.getDue_date());
		cardsChart.add(card);
		card = init_fulfilled_card();
		cardsChart.add(card);
		card = init_proof_card();
		cardsChart.add(card);
		card = init_chart_detail_card();
		cardsChart.add(card);
		
		/*for (int i = 0; i < 5; i++) {
			card = init_chart_card();
			cardsChart.add(card);
		}*/
		CardArrayAdapter mCardArrayAdapterGrades = new CardArrayAdapter(getActivity(), cardsChart);

		CardListView listView = (CardListView) getActivity().findViewById(R.id.card_list);
		if (listView != null) {
			listView.setAdapter(mCardArrayAdapterGrades);
		}
	}
	private Card init_chart_card() {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		ChartBarCards card = new ChartBarCards(getActivity());
		
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
	private Card init_info_card(String content, String type, String date) {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		InfoLongCard card = new InfoLongCard(getActivity());
		card.content = content;
		card.type = type;
		card.num = number;
		card.dateContent = date;
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
	private Card init_fulfilled_card() {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		FulfilledCard card = new FulfilledCard(getActivity());
		
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
	private Card init_proof_card() {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		ProofCard card = new ProofCard(getActivity());
		
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
	private Card init_chart_detail_card() {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		DetailPartyChart card = new DetailPartyChart(getActivity());
		
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
	
	
	
}