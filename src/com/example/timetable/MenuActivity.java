package com.example.timetable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MenuActivity extends Activity {

	private Spinner yearSpinner;
	private Spinner secSpinner;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		yearSpinner = (Spinner) findViewById(R.id.year_spinner);
		yearSpinner.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "1", "2",
						"3", "4" }));
		secSpinner = (Spinner) findViewById(R.id.sec_spinner);
		secSpinner.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "B1", "B2",
						"B3", "B4" }));

	}

	public void submit(View v) {
		Intent classListIntent = new Intent(this,MainActivity.class);
		classListIntent.putExtra("YEAR", yearSpinner.getSelectedItem().toString());
		classListIntent.putExtra("SECTION", secSpinner.getSelectedItem().toString());
		startActivity(classListIntent);
	}
}
