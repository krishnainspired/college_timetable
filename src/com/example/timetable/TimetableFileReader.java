package com.example.timetable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TimetableFileReader {
	
	public List<TimeTableData> readTimeTableFile(InputStream inputStream) {
		List<TimeTableData> timetableList = null;
		try {
			BufferedReader a = new BufferedReader(new InputStreamReader(
					inputStream));
			
			TimeTableData ttd = new TimeTableData();
			timetableList = new ArrayList<TimeTableData>();
			int linecount = 0;
			for (;;) {
				String line = a.readLine();
				if (line != null) {
					if(!line.startsWith("--------------------")) {
						switch (linecount) {
						case 0:
							ttd.setTitle(line);		
							break;
						case 1:
							ttd.setName(line);		
							break;
						case 2:
							ttd.setLectName(line);		
							break;
						case 3:
							ttd.setWeekday(line);		
							break;
						case 4:
							ttd.setTime(line);		
							break;
						default:
							break;
						}
						linecount++;
					}else {
						linecount = 0;
						timetableList.add(ttd);
						ttd = new TimeTableData();
					}
				}else {
					break;
				}
			}
			System.out.println(timetableList.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timetableList;
	}

}
