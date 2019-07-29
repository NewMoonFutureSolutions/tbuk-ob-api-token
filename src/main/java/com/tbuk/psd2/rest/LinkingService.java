package com.tbuk.psd2.rest;


import com.tbuk.psd2.model.common.HttpHeaders;

import com.tbuk.psd2.model.linking.AuthorizationResponse;
import com.tbuk.psd2.rest.error.LinkServiceException1;
import com.tbuk.psd2.service.ConsentServ;
import com.tbuk.psd2.service.LinkingServ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/linking",description="Linking Service",produces ="application/json")
public class LinkingService {
 
	@Autowired
    LinkingServ service;
  	
	@RequestMapping(value="/linking/authorizations/{accessToken}",method=RequestMethod.GET)
	public ResponseEntity<AuthorizationResponse> getAuthorisation(@PathVariable(value="accessToken") String accessToken)  {
        AuthorizationResponse response=null;
	    try{
            response=service.authorisationResponse(accessToken);
        }catch (Exception e){
	    	e.printStackTrace();
	    	throw new LinkServiceException1("Access token is missing or invalid.");
	    }
		return new ResponseEntity<AuthorizationResponse>(response,HttpStatus.OK);
	}




}

