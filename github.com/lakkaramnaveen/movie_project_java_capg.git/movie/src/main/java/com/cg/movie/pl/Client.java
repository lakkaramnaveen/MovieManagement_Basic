package com.cg.movie.pl;

import java.util.InputMismatchException;
import java.util.Scanner; //importing Scanner class

import com.cg.movie.bean.Screen; //importing Screen class from bean package
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;//importing MovieException i.e user defined class from exception package
import com.cg.movie.service.AdminService;
import com.cg.movie.service.AdminServiceImpl;//importing AdminServiceImpl class from service package

public class Client {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);// Scanner class object created
		AdminService adminService = new AdminServiceImpl();// AdminService reference and AdminServiceImpl objected
															// created
		Theater theater = null; // Theater reference ... pointing to null!!
		Screen screen = null; // Screen reference ....pointing to null!!
		Theater t = null;// Another reference of Theater
		String choice = "";
		//int choice = 0;
		//try {
			while (choice != "5") {
				System.out.println("1.Add Theater\n2.Delete Theater\n3.Add Screen\n4.Delete Screen\n5.Exit");
				System.out.println("Enter your choice");
				// creating choice variable
				choice = scanner.nextLine();// Taking input through console
				switch (choice) {

				case "1":
					try {
						System.out.println("Enter theater Id");
						int theaterId = scanner.nextInt();// Taking theater Id from user/console
						scanner.nextLine();
						System.out.println("Enter theater Name");
						String theaterName = scanner.nextLine();// Taking theater name from user/console
						System.out.println("Enter theater City");
						String theaterCity = scanner.nextLine();// Taking theater city from user/console
						System.out.println("Enter Manager Name");
						String managerName = scanner.nextLine();// Taking manager name from user/console
						System.out.println("Enter Manager Contact");
						String managerContact = scanner.nextLine();// Taking manager contact from user/console

						theater = new Theater();// Theater object created

						// calling setTheaterId method using theater object
						theater.setTheaterId(theaterId);
						theater.setTheaterName(theaterName);
						theater.setTheaterCity(theaterCity);
						theater.setManagerName(managerName);
						theater.setManagerContact(managerContact);
						// using try catch for exception handling
						t = adminService.addTheater(theater);// calling addTheater method using admin object
						// because the method is defined in it from AdminServiceImpl
						System.out.println("Added theater sucessfully ");
					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.err.println("Type MisMatch Enter Correct Inputs");
					}

					break;

				case "2":
					try {
						if (theater.getTheaterId() >0) {
							System.out.println("Enter theater id to delete");// Asking user to enter theater id to
																				// delete
							int theaterId1 = scanner.nextInt();// Taking input
							try {
								boolean flag = adminService.deleteTheater(theaterId1);// Calling delete theater
								if (flag == true) {
									System.out.println("Deleted successfully");
								}

							} catch (MovieException e) {
								System.err.println(e.getMessage());// printing error message
							}
						}
					} catch (Exception e) {
						System.err.println("Add theater first so that you can delete it");
					}
					break;

				case "3":
					try {
						if (theater.getTheaterId() > 0) {
							System.out.println("Enter Screen Id");
							int screenId = scanner.nextInt();// Taking input from user
							scanner.nextLine();
							System.out.println("Enter Screen name");
							String screenName = scanner.nextLine();
							System.out.println("Enter no of Rows");
							int rows = scanner.nextInt();
							System.out.println("Enter no of columns");
							int columns = scanner.nextInt();

							screen = new Screen();// Screen class object created

							screen.setScreenId(screenId);
							screen.setTheatreId(theater.getTheaterId());
							screen.setScreenName(screenName);
							screen.setRows(rows);
							screen.setColumns(columns);// Setting values to screen

							try {
								adminService.addScreen(screen);// calling addScreen method surrounded with try catch
								System.out.println("Screen added successfully under theater " + theater.getTheaterId());
							} catch (MovieException e) {
								System.err.println(e.getMessage());
							}

						}
					}

					catch (Exception e) {

						System.err.println("Add theater first so that you can add Screen in it");
					}
					break;

				case "4":
					try {
						if (theater.getTheaterId()> 0) {
							System.out.println("Enter Screen Id to delete ");
							int screenId1 = scanner.nextInt();

							try {
								boolean flag = adminService.deleteScreen(screenId1);// calling deleteScreen method using
																					// admin
								// object and surrounded with try catch

								if (flag == true)
									System.out.println("Deleted succcessfully");
							} catch (MovieException e) {

								System.err.println(e.getMessage());// printing error message
							}
						}
					} catch (Exception e) {

						System.err.println("Add theater first and then Screen too");
					}

					break;

				case "5":
					System.out.println("Thank you!!");

					return; // It will terminate the method

				}

			}

//		} catch (InputMismatchException e) {
//			System.err.println("Please enter valid input //// must be in numbers not alphabets");
//			Client cl = new Client();
//			cl.main(args);
//		}
			
	}

}
