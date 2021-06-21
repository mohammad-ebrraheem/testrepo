package com.beyondapps.pointsgame.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.beyondapps.pointsgame.enums.Errors;
import com.beyondapps.pointsgame.exception.BeyondAppsBusinessException;
import com.beyondapps.pointsgame.model.Account;

public class CacheManager {

	private static CacheManager cacheManager = new CacheManager();
	private Map<Long, Account> accounts = new HashMap<>();

	private CacheManager() {
		reset();
	}

	public List<Account> getAccounts(long id) {
		List<Account> list = new LinkedList<>();
		if (id == -1) {
			list.addAll(accounts.values());
		} else {
			Account account = accounts.get(id);
			if (account != null) {
				list.add(account);
			}
		}
		return list;
	}

	private void reset() {
		Account a1 = new Account(1, "player1", 1000);
		Account a2 = new Account(2, "player2", 1000);
		Account a3 = new Account(3, "player3", 1000);
		Account a4 = new Account(4, "player4", 1000);
		Account a5 = new Account(5, "player5", 1000);
		accounts.put(a1.getId(), a1);
		accounts.put(a2.getId(), a2);
		accounts.put(a3.getId(), a3);
		accounts.put(a4.getId(), a4);
		accounts.put(a5.getId(), a5);

	}

	public synchronized void transferPoints(long fromID, long toID, long points) throws BeyondAppsBusinessException {
		Account fromAccount = accounts.get(fromID);
		Account toAccount = accounts.get(toID);
		if (fromAccount == null || toAccount == null || points <= 0) {
			Errors err = Errors.INVALID_INPUTS_ERROR;
			throw new BeyondAppsBusinessException(err.errorCode(), err.errorDescription());
		}
		if (fromAccount.getPoints() < points) {
			Errors err = Errors.INSUFFICIENT_POINTS_ERROR;
			throw new BeyondAppsBusinessException(err.errorCode(), err.errorDescription());
		}
		fromAccount.setPoints(fromAccount.getPoints() - points);
		accounts.put(fromAccount.getId(), fromAccount);
		toAccount.setPoints(toAccount.getPoints() + points);
		accounts.put(toAccount.getId(), toAccount);
	}

	public static CacheManager getInstance() {
		return cacheManager;
	}

}
