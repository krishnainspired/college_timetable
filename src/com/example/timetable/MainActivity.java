package com.example.timetable;

import java.io.IOException;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	ListView testlist;
	private String[] values;
	private List<TimeTableData> timeTableList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testlist = (ListView) findViewById(R.id.listView1);
		testlist.setOnItemClickListener(this);
		getValues();
		testlist.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values));
	}

	private void getValues() {
		String year = this.getIntent().getStringExtra("YEAR");
		String section = this.getIntent().getStringExtra("SECTION");

		TimetableFileReader tfr = new TimetableFileReader();
		try {
			timeTableList = tfr.readTimeTableFile(getAssets().open(
					year + "-" + section + ".txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values = new String[timeTableList.size()];
		int i = 0;
		for (TimeTableData timeTableData : timeTableList) {
			values[i] = timeTableData.getFormattedText();
			i++;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		Intent detailIntent = new Intent(this, ClassDetailActivity.class);
		detailIntent.putExtra("DISP_TEXT", timeTableList.get(pos).getFormattedText());
		detailIntent.putExtra("WEEKDAY", timeTableList.get(pos).getWeekday());
		startActivity(detailIntent);
	}
}
