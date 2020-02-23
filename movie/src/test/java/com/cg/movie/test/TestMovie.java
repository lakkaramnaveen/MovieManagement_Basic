package com.cg.movie.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

class TestMovie {

	AdminDao adminDao;
	Theater theater;
	Screen screen;

	@BeforeEach
	public void setup() {
		adminDao = new AdminDaoImpl();
	}

	@Test
	public void testAddTheater() throws Exception {
		theater = new Theater(2134, "shiva", "hyderbad", null, null, "rahul", "9876543210");

		Theater th = adminDao.addTheater(theater);

		assertEquals(2134, th.getTheaterId());

	}

	@Test
	public void testAddTheaterException() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");

		adminDao.addTheater(theater);

		assertThrows(MovieException.class, () -> adminDao.addTheater(theater));

	}

	@Test
	public void testDeleteTheater() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		adminDao.addTheater(theater);
		boolean flag = adminDao.deleteTheater(2134);

		assertTrue(flag);
	}

	@Test
	public void testDeleteTheaterException() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		adminDao.addTheater(theater);
		assertThrows(MovieException.class, () -> adminDao.deleteTheater(2234));
	}

	@Test
	public void testAddScreen() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		Theater th = adminDao.addTheater(theater);
		screen = new Screen(1133, th.getTheaterId(), "screen1", null, null, 12, 12);
		Screen sc = adminDao.addScreen(screen);
		assertEquals(1133, sc.getScreenId());

	}

	@Test
	public void testAddScreenException() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		Theater th = adminDao.addTheater(theater);
		screen = new Screen(1133, th.getTheaterId(), "screen1", null, null, 12, 12);
		adminDao.addScreen(screen);
		assertThrows(MovieException.class, () -> adminDao.addScreen(screen));

	}

	@Test
	public void testDeleteScreen() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		Theater th = adminDao.addTheater(theater);
		screen = new Screen(1133, th.getTheaterId(), "screen1", null, null, 12, 12);
		adminDao.addScreen(screen);
		boolean flag = adminDao.deleteScreen(1133);

		assertTrue(flag);
	}

	@Test
	public void testDeleteScreenException() throws Exception {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		Theater th = adminDao.addTheater(theater);
		screen = new Screen(1133, th.getTheaterId(), "screen1", null, null, 12, 12);
		adminDao.addScreen(screen);

		assertThrows(MovieException.class, () -> adminDao.addScreen(screen));
	}
}
