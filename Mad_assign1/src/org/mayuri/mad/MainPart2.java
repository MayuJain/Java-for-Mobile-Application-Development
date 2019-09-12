package org.mayuri.mad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainPart2 {
    /*
    * Question 2:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to count the number of users living each state.
    * - Print out the list of State, Count order in ascending order by count.
    * */
	
	// function to sort hashmap by values 
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

    public static void main(String[] args) {

    	ArrayList<User> usersArray = new ArrayList<User>();
        //example on how to access the Data.users array.
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
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(User usr: usersArray) {
        	String state = usr.getState();
        	if(hm.containsKey(state)){
        		int count = hm.get(state);
        		hm.replace(state, count, count+1);
        	}else {
        		hm.put(state,1);
        	}
        }
        Map<String, Integer> sortedbyvalue = sortByValue(hm);
        System.out.println(sortedbyvalue.toString());
    }
}