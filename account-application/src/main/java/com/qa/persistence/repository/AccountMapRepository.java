package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountMapRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	@Inject
	private JSONUtil util;
	private HashMap<Long, Account> accountList = new HashMap<Long,Account>();
	private String string;
	

	@Override
	public String getAllAccounts() {
		for ( int i= 0; i < accountList.size() ; i++) {
			string = accountList.get(i).getFirstName();
			
		}
		
		return string;
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String accout) {
		
		Account anAccount = util.getObjectForJSON(accout, Account.class);
		accountList.put(anAccount.getId(),anAccount);
	
		return "{Account succesfully created}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id,String accout) {
		Account anAccount = util.getObjectForJSON(accout, Account.class);
	
		accountList.get(id).setSecondName(anAccount.getSecondName());
		accountList.get(id).setFirstName(anAccount.getFirstName());
		accountList.get(id).setAccountNumber(anAccount.getAccountNumber());
	
		return "{\"MESSAGE\" : \"account was succesfully updated\"}";
	}
	


	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
	accountList.get(id).setFirstName("");
	accountList.get(id).setSecondName("");
	//accountList.remove(id);
		return null;
	}

	public HashMap<Long, Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(HashMap<Long, Account> accountList) {
		this.accountList = accountList;
	}
	
	
	

}