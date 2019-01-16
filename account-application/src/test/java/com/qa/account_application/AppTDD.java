package com.qa.account_application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.accountapplication.Account;
import com.qa.accountapplication.Service;

public class AppTDD {
	
	Service manager = new Service();

	@Before
	public void beforeStuff() {

		

		System.out.println("Hello world to the standard out");

		Account customer1 = new Account("jimmy", "neutron", 1);
		Account customer2 = new Account("John", "Doe", 2);
		Account customer3 = new Account("jimmy", "doe", 3);
		manager.addAccount(customer3);

		manager.addAccount(customer1);
		manager.addAccount(customer2);
	}

	@Test
	public void accountAddTest() {
		
		assertEquals( "jimmy", manager.accountList.get(1).getFirstName());
		
	}
	
	@Test
	public void hashMapTest() {
		assertEquals(3,manager.accountList.size());
	}
	
	@Test
	public void firstNameSearch() {
		
		assertEquals(2,manager.searchByName("jimmy"));
	}

	
}
