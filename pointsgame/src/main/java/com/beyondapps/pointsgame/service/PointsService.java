package com.beyondapps.pointsgame.service;

import org.springframework.stereotype.Service;
import com.beyondapps.pointsgame.cache.CacheManager;
import com.beyondapps.pointsgame.exception.BeyondAppsBusinessException;
import com.beyondapps.pointsgame.model.Account;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PointsService {

	Logger logger = Logger.getLogger(PointsService.class.getName());

	public List<Account> getAccounts(long id) throws Exception {
		List<Account> accounts = null;
		try {
			CacheManager cacheManager = CacheManager.getInstance();
			accounts = cacheManager.getAccounts(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
		return accounts;
	}

	public void transfer(long fromID, long toID, long points) throws BeyondAppsBusinessException {
		try {
			CacheManager cacheManager = CacheManager.getInstance();
			cacheManager.transferPoints(fromID, toID, points);
		} catch (BeyondAppsBusinessException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}
}
