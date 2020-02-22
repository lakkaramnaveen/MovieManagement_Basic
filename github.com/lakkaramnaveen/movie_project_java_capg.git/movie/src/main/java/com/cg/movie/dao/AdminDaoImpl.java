package com.cg.movie.dao;

import java.util.ArrayList;// importing inbuilt packages
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.movie.bean.Screen;//importing user defined packages for accessing classes
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class AdminDaoImpl implements AdminDao {
	private Map<Integer, Theater> map;// map reference with private modifier
	private List<Screen> listOfScreens;
	@SuppressWarnings("unused") // suppressing warnings
	private Theater theater = null;
	private Theater th = null;

	public AdminDaoImpl() {// default constructor
		listOfScreens = new ArrayList<Screen>();// creating objects of list / map / theater
		map = new HashMap<Integer, Theater>();
		theater = new Theater();
	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {// addTheater method

		boolean flag = map.containsKey(theater.getTheaterId());// verifying whether it contains the theater Id

		if (flag) {// checking flag status

			throw new MovieException("Id already exists");

		}

		th = theater;// storing theater object reference in another theater object
		map.put(theater.getTheaterId(), th);// putting values in map

		return theater;// returning theater object
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {// deleteTheater

		boolean flag = map.containsKey(theaterId);// verifying whether it contains the theater Id

		if (flag) {
			map.remove(theaterId);// removing theater using theaterId as key
			return flag;
		} else {
			throw new MovieException(theaterId + "Id is not found");
		}

	}

	@Override
	public Screen addScreen(Screen screen) throws MovieException {// addScreen method

		int screenId = screen.getScreenId();// getting screen id
		List<Integer> list1 = listOfScreens.stream().map(p -> p.getScreenId()).collect(Collectors.toList());
		// creating a separate list for screen id
		boolean flag1 = list1.contains(screenId);// verifying screen id exist or not

		if (flag1) {
			throw new MovieException("Screen Id already exists ");
		}
		listOfScreens.add(screen);// adding screen object to list of screens
		th.setListOfScreens(listOfScreens);// putting list of screens in theater

		return screen;
	}

	@Override
	public boolean deleteScreen(int screenId) throws MovieException {
		boolean flag = false;

		List<Integer> list1 = listOfScreens.stream().map(p -> p.getScreenId()).collect(Collectors.toList());
		// creating a separate list for screen id
		flag = list1.contains(screenId);// verifying screen id exist or not
		if (flag) {
			for (Screen s : listOfScreens) {//for each iterating through list of screens
				if (s.getScreenId() == screenId) {
					listOfScreens.remove(s);//remove screen object from list of screens
					flag = true;
					break;
				}
			}
		} else {
			throw new MovieException("Screen Id does not exsits");
		}
		return flag;
	}

}
