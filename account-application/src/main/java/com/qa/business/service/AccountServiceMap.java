package com.qa.business.service;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;

public class AccountServiceMap {

	private Map<Integer, Account> accountMap;

	private int count = 0;

	public AccountServiceMap() {
		accountMap = new HashMap<>();
	}

	public void addAccountFromMap(Account userAccount) {
		accountMap.put(count, userAccount);
		count++;
	}

	public void removeAccountFromMap(Integer accountToRemove) {
		boolean countExists = accountMap.containsKey(accountToRemove);
		if (countExists) {
			accountMap.remove(accountToRemove);
		}
	}

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public int getNumberOfAccountWithFirstName( String firstNameOfAccount) {
		return (int) accountMap.values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(firstNameOfAccount)).count();
	}
	

}
