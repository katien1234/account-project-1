package com.qa.accountapplication;

import java.util.HashMap;


public class Service {
	
	public int count;
	


public HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();


	
	
	
	public void addAccount(Account account) {
		accountList.put(account.getAccountNumber(), account);
		
	}
	
	public int searchByName(String input) {
		
		for (int i = 1 ; i< accountList.size()+1; i++) {
			
			if (accountList.get(i).getFirstName().equals(input)) {
				count++;
				System.out.println(count);
			}
			
		}
		return count;
		
	}
	
	
	
	

}

