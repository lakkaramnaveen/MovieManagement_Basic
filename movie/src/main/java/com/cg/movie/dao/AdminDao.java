package com.cg.movie.dao;

import com.cg.movie.bean.Screen;//importing user defined packages 
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminDao {// Admin interface

	public Theater addTheater(Theater theater) throws MovieException;// abstract methods

	public boolean deleteTheater(int theaterId) throws MovieException;

	public Screen addScreen(Screen screen) throws MovieException;

	public boolean deleteScreen(int screenId) throws MovieException;

}
