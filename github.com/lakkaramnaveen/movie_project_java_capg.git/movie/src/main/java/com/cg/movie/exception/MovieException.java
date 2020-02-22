package com.cg.movie.exception;

@SuppressWarnings("serial")
public class MovieException extends Exception {// movie exception
	public MovieException(String message) {

		super(message);// Parameterized constructor

	}

	public MovieException() {// default constructor

		super();

	}

}
