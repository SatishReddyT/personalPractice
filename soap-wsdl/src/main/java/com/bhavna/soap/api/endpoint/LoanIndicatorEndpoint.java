package com.bhavna.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bhavna.soap.api.loaneligibility.Acknowledgement;
import com.bhavna.soap.api.loaneligibility.CustomerRequest;
import com.bhavna.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanIndicatorEndpoint {

	private static final String NAMESPACE = "http://www.bhavna.com/soap/api/loanEligibility";
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
