package com.android.ceehack.trust.cardfragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ceehack.trust.R;
import com.android.ceehack.trust.cards.ChartCard;


public class CardsGraphFragment extends Fragment {
	public CardsGraphFragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.cards_fragment_chart, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initCards();
	}

	private void initCards() {

		// Init an array of Cards
		ArrayList<Card> cardsGrades = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			Card card = init_chart_card();
			cardsGrades.add(card);
		}
		CardArrayAdapter mCardArrayAdapterGrades = new CardArrayAdapter(getActivity(), cardsGrades);

		CardListView listView = (CardListView) getActivity().findViewById(R.id.card_list);
		if (listView != null) {
			listView.setAdapter(mCardArrayAdapterGrades);
		}
	}

	private Card init_chart_card() {
		ChartCard card = new ChartCard(getActivity());

		CardExpand expand = new CardExpand(getActivity());
		card.addCardExpand(expand);
		card.setBackgroundResource(getResources().getDrawable(R.drawable.card_back));
		return card;
	}
}