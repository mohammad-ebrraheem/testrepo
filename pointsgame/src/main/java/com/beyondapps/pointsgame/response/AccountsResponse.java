package com.beyondapps.pointsgame.response;

import java.util.List;

import com.beyondapps.pointsgame.model.Account;

public class AccountsResponse extends AbstractResponse {

	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
