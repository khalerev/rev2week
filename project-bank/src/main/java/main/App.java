package main;

import common.dao.HomePage;

public class App {

	public static void main(String[] args) {
		HomePage home = new HomePage();
		home.navigateHome();
		System.out.println("Exited.");
	}

}