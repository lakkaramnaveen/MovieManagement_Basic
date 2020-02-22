package com.cg.movie.service;

import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;// private adminDao field

	public AdminServiceImpl() {// constructor

		adminDao = new AdminDaoImpl();// AdminDaoImpl object is created

	}

//implementing abstract methods in AdminServiceImpl class
	@Override
	public Theater addTheater(Theater theater) throws MovieException {// Method with public Access modifier

		int id = theater.getTheaterId();// getting theater ID
		boolean flag = validateTheaterId(id);// calling validateTheaterId method

		if (flag == false) {// checking condition

			throw new MovieException("Theater Id must be 4 digit starting with 2");// throwing Exception
		}
		String name = theater.getTheaterName();// getting theater name
		boolean flag1 = validateName(name);// calling validateName method

		if (flag1 == true) {
			throw new MovieException("Theater Name must not be Null ");
		}

		String mname = theater.getManagerName();// getting manager name
		boolean flag2 = validateName(mname);// calling validateName with passing manager name

		if (flag2 == true) {
			throw new MovieException("Manager Name must not be Null ");
		}
		String mcontact = theater.getManagerContact();// getting manager contact
		boolean flag3 = validateContact(mcontact);// calling validateContact method

		if (flag3 == false) {
			throw new MovieException("Manager Contact Number must be 10 digits");
		}
		Theater th = adminDao.addTheater(theater);// calling addTheater using from AdminDaoImpl class

		return th;// returning theater object to client
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {

		boolean flag = validateTheaterId(theaterId);// calling validateTheaterId method passing theaterId

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}

		boolean flag1 = adminDao.deleteTheater(theaterId);// calling deleteTheater from dao layer

		return flag1;// returning flag to client i.e, presentation layer
	}

	@Override // it is used inorder not to create a logical bug
	public Screen addScreen(int theaterId, Screen screen) throws MovieException {
		int id = screen.getScreenId();// getting screen id

		boolean flag = validateScreenId(id);// calling validateScreenId with passing id

		if (flag == false) {

			throw new MovieException("Screen Id must be 4 digit ");
		}
		String name = screen.getScreenName();// getting screen name
		boolean flag1 = validateName(name);// calling validateName from same class

		if (flag1 == true) {
			throw new MovieException("Screen Name must not be Null ");
		}

		Screen sc = adminDao.addScreen(theaterId, screen);// calling addScreen

		return sc;// returning Screen object to Client class
	}

	@Override
	public boolean deleteScreen(int theaterId, int screenId) throws MovieException {

		boolean flag = validateScreenId(screenId);// calling validateScreenId

		if (!flag) {
			throw new MovieException("Screen Id must be 4 digit ");
		}

		boolean flag1 = adminDao.deleteScreen(theaterId, screenId);// calling deleteScreen from dao layer

		return flag1;
	}

	@Override
	public boolean validateTheaterId(int id) throws MovieException {
		boolean flag = false;

		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);
			flag = s.matches("(2)[0-9]{3}");// validating theater Id

		}

		return flag;

	}

	@Override
	public boolean validateName(String name) throws MovieException {

		boolean flag = false;
		flag = name.isEmpty();// validating name of theater / screen / manager name

		if (flag) {
			flag = true;

		}

		return flag;
	}

	@Override
	public boolean validateContact(String number) throws MovieException {

		boolean flag = false;
		flag = number.matches("[0-9]{10}");// validating manager contact

		return flag;
	}

	@Override
	public boolean validateScreenId(int id) throws MovieException {
		boolean flag = false;

		if (id == 0) {
			flag = false;
		} else {
			String s = Integer.toString(id);// converting integer to string
			flag = s.matches("[0-9]{4}");// validating screen id

		}

		return flag;

	}

}
