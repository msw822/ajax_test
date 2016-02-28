package com.hp.test.app.beans;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private String bookName;
	private Map<String,ShoppingCartItem> items = new HashMap<String,ShoppingCartItem>();
	
	public void addCart(String bookName, int price){
		
		this.bookName = bookName;
		if(items.containsKey(bookName)){
			ShoppingCartItem item=items.get(bookName);
			item.setCount(item.getCount()+1);
		}else{
			ShoppingCartItem item1 = new ShoppingCartItem();
			item1.setBookName(bookName);
			item1.setCount(1);
			item1.setPrice(price);
			
			items.put(bookName, item1);			
		}
	}
	
	

	public int getTotalCount(){
		int total =0;
		
		for(ShoppingCartItem item: items.values()){
			total +=item.getCount();
		}		
		return total;		
	}
	
	public int getTotalMoney(){
		int moeny =0;
		
		for(ShoppingCartItem item: items.values()){
			moeny +=item.getPrice() * item.getCount();
		}		
		return moeny;		
	}
	
	public String  getBookName(){
		return 	this.bookName;
	}
	

}
