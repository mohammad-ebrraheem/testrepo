package com.beyondapps.pointsgame.model;

public class Account {

	private long id;
	private String name;
	private long points;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account(long id, String name, long points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

}