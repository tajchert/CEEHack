package com.android.ceehack.trust.cardfragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
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
import com.android.ceehack.trust.cards.InfoCard;
import com.android.ceehack.trust.data.JsonObjResult;


public class CardsPartyFragment extends Fragment {
	public CardsPartyFragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.cards_fragment_chart, container,
				false);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(7, 152, 227)));

		LinearLayout ly = (LinearLayout) getActivity().findViewById(R.id.mainLay);
		ly.setBackgroundColor(Color.parseColor("#232323"));
        
		initCards();
	}

	private void initCards() {

		// Init an array of Cards
		ArrayList<Card> cardsChart = new ArrayList<Card>();
		Card card = init_chart_card();
		cardsChart.add(card);
		JsonObjResult tmp;
		for (int i = 0; i < Application.listaPostow.size(); i++) {
			tmp = Application.listaPostow.get(i);
			card = init_info_card(tmp.getBrief(), tmp.getStatus(), i, tmp.getDue_date());
			cardsChart.add(card);
		}
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
	private Card init_info_card(String content, String type, int number, String date) {
		//ChartPieCard card = new ChartPieCard(getActivity());
		
		InfoCard card = new InfoCard(getActivity());
		card.content = content;
		card.type = type;
		card.num = number;
		card.dateContent = date;
		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
}