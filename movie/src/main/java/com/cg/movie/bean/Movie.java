package com.cg.movie.bean;

import java.time.LocalDate;//importing inbuilt packages
import java.util.List;

public class Movie {

	private int movieId;// creating fields with private modifier
	private String movieName;
	private List<Show> movieGenre;
	private String movieDirector;
	private int movieLength;
	private String[] languages;
	private LocalDate movieReleaseDate;

	public Movie(int movieId, String movieName, List<Show> movieGenre, String movieDirector, int movieLength,
			String[] languages, LocalDate movieReleaseDate) {// parameterized  constructor
		super();
		this.movieId = movieId;
		this.movieName = movieName;// assigning fields
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages = languages;
		this.movieReleaseDate = movieReleaseDate;
	}

	public Movie() {// default constructor
		super();
	}

	public int getMovieId() {// getters and setters
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<Show> getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(List<Show> movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

}
