package com.android.ceehack.trust;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.android.ceehack.trust.cardfragments.CardsPartyFragment;

public class ActivityParty extends Activity {
	private static final int CONTENT_VIEW_ID = 10101010;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FrameLayout frame = new FrameLayout(this);
		frame.setId(CONTENT_VIEW_ID);
		setContentView(frame, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		if (savedInstanceState == null) {
			// Fragment newFragment = new DebugExampleTwoFragment();
			Fragment charFragment = new CardsPartyFragment();
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.add(CONTENT_VIEW_ID, charFragment).commit();
		}

		ActionBar actionBar = getActionBar();

		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	public static class DebugExampleTwoFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			EditText v = new EditText(getActivity());
			v.setText("Hello Fragment HI!");
			return v;
		}
	}

	public boolean onOptionsItemSelected(int featureId, MenuItem item) {

		int itemId = item.getItemId();

		if (itemId == android.R.id.home) {
			super.onBackPressed();
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_party, menu);
		return true;
	}

}
