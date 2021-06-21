package com.beyondapps.pointsgame.controllers;

import org.springframework.web.bind.annotation.*;
import com.beyondapps.pointsgame.enums.Errors;
import com.beyondapps.pointsgame.exception.BeyondAppsBusinessException;
import com.beyondapps.pointsgame.model.Account;
import com.beyondapps.pointsgame.request.TransferRequest;
import com.beyondapps.pointsgame.response.AccountsResponse;
import com.beyondapps.pointsgame.response.TransferResponse;
import com.beyondapps.pointsgame.service.PointsService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/points")
public class PointsController implements IController {

	private final PointsService pointsService;

	Logger logger = Logger.getLogger(PointsController.class.getName());

	public PointsController(PointsService pointsService) {
		this.pointsService = pointsService;
	}

	@GetMapping("/accounts")
	public AccountsResponse getAccounts(@RequestParam(defaultValue = "-1") String id) {
		AccountsResponse response = null;
		try {
			response = new AccountsResponse();
			List<Account> accounts = pointsService.getAccounts(Long.valueOf(id));
			response.setAccounts(accounts);
		} catch (Exception e) {
			setFault(response, Errors.SERVICE_LAYER_ERROR);
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return response;
	}

	@PostMapping("/transfer")
	public TransferResponse transfer(@RequestBody TransferRequest request) {
		TransferResponse response = null;
		try {
			response = new TransferResponse();
			pointsService.transfer(request.getFromID(), request.getToID(), request.getPoints());
			response.setStatus(true);
		} catch (BeyondAppsBusinessException e) {
			setFault(response, e.getErrorCode(), e.getMessage());
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			setFault(response, Errors.SERVICE_LAYER_ERROR);
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return response;
	}
}
