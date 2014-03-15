package com.android.ceehack.trust.ui;

import com.android.ceehack.trust.R;
import com.android.ceehack.trust.R.layout;
import com.android.ceehack.trust.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainSelectorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_selector);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_selector, menu);
		return true;
	}

}
