package com.qa.account_application;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Service manager = new Service();
    	
    	
    	
        System.out.println( "Hello world to the standard out" );
        
        Account customer1 = new Account("jimmy","neutron",1);
        Account customer2 = new Account("John","Doe",2);
        
        manager.addAccount(customer1);
        manager.addAccount(customer2);
        manager.accountDisplay();
       
        
        
    }
}
