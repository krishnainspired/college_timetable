package com.example.timetable;

public class TimeTableData {

	private String title;
	private String name;
	private String lectName;
	private String weekday;
	private String time;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLectName() {
		return lectName;
	}

	public void setLectName(String lectName) {
		this.lectName = lectName;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFormattedText() {
		return this.getTime() + "\n" + this.getName() + "\n" + this.getTitle()
				+ "\n" + this.getLectName();
	}
}
