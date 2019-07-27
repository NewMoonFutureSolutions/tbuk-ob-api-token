package com.tbuk.psd2.rest;

// READY

import com.tbuk.psd2.service.ConsentServ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/consents",description="Consent Service",produces ="application/json")
public class ConsentService {
 
	@Autowired
	ConsentServ service;

	@RequestMapping(value="/consents/{tokenConsentId}/created",method=RequestMethod.PUT)
	public ResponseEntity<String> created(@PathVariable(value="tokenConsentId") String tokenConsentId)  {
	    System.out.println("Consent has been created by Token :"+tokenConsentId);
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value="/consents/{tokenConsentId}/revoked",method=RequestMethod.PUT)
	public ResponseEntity<String> revoked(@PathVariable(value="tokenConsentId") String tokenConsentId)  {
        System.out.println("Consent has been revoked by Token :"+tokenConsentId);
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	

}

