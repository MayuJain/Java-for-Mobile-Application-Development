package org.mayuri.mad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainPart1 {
	/*
	 * Question 1: - In this question you will use the Data.users array that
	 * includes a list of users. Formatted as :
	 * firstname,lastname,age,email,gender,city,state - Create a User class that
	 * should parse all the parameters for each user. - Insert each of the users in
	 * a list. - Print out the TOP 10 oldest users.
	 */

	public static void main(String[] args) {

		ArrayList<User> usersArray = new ArrayList<User>();
		// example on how to access the Data.users array.
		for (String str : Data.users) {
			// System.out.println(str);
			String[] resultingTokens = str.split(",");
			String firstName = resultingTokens[0];
			String lastName = resultingTokens[1];
			int age = Integer.parseInt(resultingTokens[2]);
			String email = resultingTokens[3];
			String gender = resultingTokens[4];
			String city = resultingTokens[5];
			String state = resultingTokens[6];
			User user = new User(firstName, lastName, age, email, gender, city, state);
			usersArray.add(user);

		}

		Collections.sort(usersArray, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return (o2.getAge() - o1.getAge());
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(usersArray.get(i));

		}
	}
}
