package com.cg.movie.service;

import com.cg.movie.bean.Screen;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminService {
	public Theater addTheater(Theater theater) throws MovieException;// defining abstract methods in AdminService
																		// interface

	public boolean deleteTheater(int theaterId) throws MovieException;

	public Screen addScreen(Screen screen) throws MovieException;

	public boolean deleteScreen(int screenId) throws MovieException;

	public boolean validateTheaterId(int id) throws MovieException;

	public boolean validateName(String name) throws MovieException;

	public boolean validateContact(String number) throws MovieException;

	public boolean validateScreenId(int id) throws MovieException;

}
