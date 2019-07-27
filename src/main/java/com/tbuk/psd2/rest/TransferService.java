package com.tbuk.psd2.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbuk.psd2.model.payment.request.PaymentRequest;
import com.tbuk.psd2.model.payment.response.PaymentResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tbuk.psd2.service.TransferServ;
@Api(value="/transfers",description="Transfer Service",produces ="application/json")
@RestController
@RequestMapping(value="")
public class TransferService {
 
	@Autowired
	TransferServ service;

	//GENERIC

	@RequestMapping(value="/transfers",method=RequestMethod.POST)
	public ResponseEntity<PaymentResponse> transfer(@RequestBody PaymentRequest paymentRequest)  {

        // Destinations kismi sorunlu gibi, degistirmek zorunda kalacaklar
		try { // GECICI : ilk odeme mesajini alabilmek icin cunku adamlar ornek vermiyorlar, dev portaldaki de schema ile uymuyor
			ObjectMapper mapper = new ObjectMapper();
			String request = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(paymentRequest);
			System.out.println("-- Received a transfer request --");
			System.out.println(request);
		}catch (Exception e){e.printStackTrace();}
		PaymentResponse response=service.transfer(paymentRequest);
		return new ResponseEntity<PaymentResponse>(response,HttpStatus.OK);

	}
	@RequestMapping(value="/transfers/{transferId}/status",method=RequestMethod.GET)
	public ResponseEntity<String> transferStatus(@PathVariable("transferId") String transferId)  {
        HttpStatus httpResponseCode=HttpStatus.OK;
        String response=service.getTransferStatus(transferId);
        if(response.startsWith("The specified transfer was not")) {httpResponseCode=HttpStatus.NOT_FOUND;}
		return new ResponseEntity<String>(response,httpResponseCode);
	}


//	@ModelAttribute
//	public HttpHeaders getHeaders(@RequestHeader(value="Authorization", required = true) String jwt,
//								  @RequestHeader(value="audience", required = true) String audiance,
//								  @RequestHeader(value="client_Id", required = true) String clientId,
//								  @RequestHeader(value="content_Type", required = false) String contentType,
//								  @RequestHeader(value="nonce", required = false) String nonce,
//								  @RequestHeader(value="x-fapi-customer-ip-address", required = false) String psuIp
//
//	)
//	{
//
//		return HttpHeaders.builder().audience(audiance).Authorization(jwt).client_Id(clientId).content_Type(contentType)
//				                     .x_fapi_customer_ip_address(psuIp).nonce(nonce).build();
//	}

}

