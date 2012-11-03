package com.example.timetable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class ClassDetailActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class_detail);
		((TextView) findViewById(R.id.weekday)).setText(getIntent()
				.getStringExtra("WEEKDAY"));
		((TextView) findViewById(R.id.disp_text)).setText(getIntent()
				.getStringExtra("DISP_TEXT"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_class_detail, menu);
		return true;
	}
}
