package com.qa.accountapplication;

import java.util.HashMap;


public class Service {
	


public HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();


	
	public void accountDisplay(){

		for (int i = 1; i <= accountList.size() ; i++) {
			
			System.out.println(accountList.get(i).getFirstName() + " " + accountList.get(i).getLastName());
			
		}
		
		
	}
	
	public void addAccount(Account account) {
		accountList.put(account.getAccountNumber(), account);
		
	}
	
	
	
	

}

