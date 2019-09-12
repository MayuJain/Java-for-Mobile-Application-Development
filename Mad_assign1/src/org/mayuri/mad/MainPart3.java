package org.mayuri.mad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainPart3 {
	/*
	 * Question 3: - In this question you will use the Data.users and
	 * Data.otherUsers array that includes a list of users. Formatted as :
	 * firstname,lastname,age,email,gender,city,state - Create a User class that
	 * should parse all the parameters for each user. - The goal is to print out the
	 * users that are exist in both the Data.users and Data.otherUsers. Two users
	 * are equal if all their attributes are equal. - Print out the list of users
	 * which exist in both Data.users and Data.otherUsers.
	 */

	public static void main(String[] args) {
		ArrayList<User> usersArray = new ArrayList<User>();
		ArrayList<User> usersOtherArray = new ArrayList<User>();
		
		// example on how to access the Data.users array.
		for (String str : Data.users) {
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
		
		System.out.println("size of usersArray:" + usersArray.size());

		for (String str : Data.otherUsers) {
			String[] resultingTokens = str.split(",");
			String firstName = resultingTokens[0];
			String lastName = resultingTokens[1];
			int age = Integer.parseInt(resultingTokens[2]);
			String email = resultingTokens[3];
			String gender = resultingTokens[4];
			String city = resultingTokens[5];
			String state = resultingTokens[6];
			User user = new User(firstName, lastName, age, email, gender, city, state);
			usersOtherArray.add(user);
		}
		
		System.out.println("size of usersOthersArray:" + usersOtherArray.size());
		
		//finding common between two arrays
		usersArray.retainAll(usersOtherArray);
		System.out.println(usersArray.size());
		
		Collections.sort(usersArray, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o2.getState().compareTo(o1.getState());
			}
		});
		
		for (User user : usersArray) {
			System.out.println(user.toString());
		}
	}
}