package com.beyondapps.pointsgame;

import static org.junit.Assert.assertEquals;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.beyondapps.pointsgame.model.Account;
import com.beyondapps.pointsgame.service.PointsService;

@SpringBootTest
class PointsgameApplicationTests {

	@Resource
	private PointsService pointsService;

	Logger logger = Logger.getLogger(PointsgameApplicationTests.class.getName());

	@Test
	public void testTransfer() {
		long points = 100;
		try {
			Account fromBefore = pointsService.getAccounts(1).iterator().next();
			long x = fromBefore.getPoints() - points;
			Account toBefore = pointsService.getAccounts(2).iterator().next();
			long y = toBefore.getPoints() + points;
			pointsService.transfer(fromBefore.getId(), toBefore.getId(), points);
			Account fromAfter = pointsService.getAccounts(1).iterator().next();
			Account toAfter = pointsService.getAccounts(2).iterator().next();
			assertEquals(fromAfter.getPoints(), x);
			assertEquals(toAfter.getPoints(), y);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}

}
