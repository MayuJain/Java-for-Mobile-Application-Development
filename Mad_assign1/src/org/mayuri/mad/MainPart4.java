package org.mayuri.mad;

import java.util.HashMap;
import java.util.Map;

public class MainPart4{
    /*
      Question 4
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record. Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element in the array represents a single item record. Each record is a string formatted as : ID, quantity. You are asked to perform the following tasks:
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record.
      Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called
      shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element the array represents a single item record. Each record is a string formatted as : ID,quantity. You are asked to perform the following tasks:
     1. Your implementation for this question should be included in MainPart3.java file.
     2. Create a StoreItem class that should parse all the parameters for each item. Hint: extract each value from a item's record using Java's String.split() method and set the
        delimiter to a comma, see provided code below. Each item record should to be assigned to a StoreItem object.
     3. Create the most efficient data structure that best fit the goal. Hint: The selected data structure should facilitate the retrieval of the item details based on the ID.
     4. The goal is to print out the receipt bill in the following format:
        ID  Name    Quantity    Price * Quantity
        123 Tomatoes 10         $30
        .
        .
        Total Bill: $400
    */

    public static void main(String[] args) {
    	
    	HashMap<Integer, StoreItem> itemMap = new HashMap<Integer, StoreItem>();
    	HashMap<Integer, Integer> quantityMap = new HashMap<Integer, Integer>();
		
		// example on how to access the Data.users array.
		for (String str : Data.items) {
			String[] resultingTokens = str.split(",");
			String name = resultingTokens[0];
			int id = Integer.parseInt(resultingTokens[1]);
			int price = Integer.parseInt(resultingTokens[2]);
			StoreItem item = new StoreItem(name, id, price);
			itemMap.put(id, item);
		}
		
		for (String str : Data.shoppingCart) {
			String[] resultingTokens = str.split(",");
			int id = Integer.parseInt(resultingTokens[0]);
			int quantity = Integer.parseInt(resultingTokens[1]);
			quantityMap.put(id, quantity);
		}
		
		int finalBill = 0;
		System.out.println("ID\tName\tQuantity\tPrice * Quantity");
		for (Map.Entry<Integer, Integer> entry : quantityMap.entrySet()) {
			
			int  id = entry.getKey();
			int itemQuantity = entry.getValue();
			StoreItem item = itemMap.get(id);
			String itemName = item.getName();
			int itemPrice = item.getPrice();
			int itemTotalAmount = itemQuantity*itemPrice;
			finalBill = finalBill + itemTotalAmount;
			System.out.println(id+"\t"+itemName+"\t"+itemQuantity+"\t"+itemTotalAmount);
		} 
		System.out.println("Total Bill:$"+finalBill);

    }
}