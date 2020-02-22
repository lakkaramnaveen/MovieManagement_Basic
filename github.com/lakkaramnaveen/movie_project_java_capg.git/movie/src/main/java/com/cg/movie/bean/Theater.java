package com.cg.movie.bean;

import java.util.List;

public class Theater {

	private int theaterId;// declaring fields with private modifier
	private String theaterName;
	private String theaterCity;
	private List<Movie> listOfmovies;
	private List<Screen> listOfScreens;
	private String managerName;
	private String managerContact;

	public Theater(int theaterId, String theaterName, String theaterCity, List<Movie> movies,
			List<Screen> listOfScreens, String managerName, String managerContact) {// parameterized constructor
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;// assigning parameter value to fields
		this.theaterCity = theaterCity;
		this.listOfmovies = movies;
		this.listOfScreens = listOfScreens;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public Theater() {// default construtor
		super();
	}

	public int getTheaterId() {// getters and setters
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public List<Movie> getMoviesList() {
		return listOfmovies;
	}

	public void setMoviesList(List<Movie> movies) {
		this.listOfmovies = movies;
	}

	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

}
