package com.microservices.CaseStudy.DriveInMovie.movieclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie1 {
	@Id
	private String movieTitle;
	private String date;
	private String time;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	public String getMovieTitle() {
		return movieTitle;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Movie1(String movieTitle, String date, String time) {
		super();
		this.movieTitle = movieTitle;
		this.date = date;
		this.time = time;

	}

	

	public Movie1()
	{
		
	}

}
