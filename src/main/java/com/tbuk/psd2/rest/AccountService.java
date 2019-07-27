package com.tbuk.psd2.rest;


import java.util.List;

import com.tbuk.psd2.model.account.TransferDestinations;
import com.tbuk.psd2.model.account.request.LinkedBankAccount;
import com.tbuk.psd2.model.account.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.service.AisService;

import io.swagger.annotations.Api;

@RestController
@Api(value="/accounts",description="CustomAccount Information Service",produces ="application/json")
//@RequestMapping(value="/accounts")
public class AccountService {
 
	@Autowired
	AisService service;

	// 1 (Ready for Token)
	@RequestMapping(value="/accounts",method=RequestMethod.POST)
	public ResponseEntity<CreateAccountResponse> accounts(@RequestBody LinkedBankAccount linkedAccount)  {

		CreateAccountResponse response=service.createAccountResponse(linkedAccount);
		return new ResponseEntity<CreateAccountResponse>(response,HttpStatus.OK);
	}
    // 2 (Ready for Token)
	@RequestMapping(value="/accounts/{bankAccountId}/balance",method=RequestMethod.GET)
	public ResponseEntity<BalanceResponse> balance(@PathVariable(value="bankAccountId") String bankAccountId)  {
		BalanceResponse response=service.balance();
		return new ResponseEntity<BalanceResponse>(response,HttpStatus.OK);
	}
	// 3 (Ready for Token)
	@RequestMapping(value="/accounts/{bankAccountId}/transactions",method=RequestMethod.GET)
	public ResponseEntity<TransactionsPageResponse> transactions(@PathVariable(value="bankAccountId") String bankAccountId,@RequestParam(value = "limit", required=false) Integer limit,@RequestParam(value = "offset", required=false) String offset)  {
		TransactionsPageResponse response=service.transactions();
		return new ResponseEntity<TransactionsPageResponse>(response,HttpStatus.OK);
	}
	// 4 (Ready for Token)
	@RequestMapping(value="/accounts/{bankAccountId}/transactions/{transactionId}",method=RequestMethod.GET)
	public ResponseEntity<TransactionResponse> transactionDetail(@PathVariable(value="bankAccountId") String bankAccountId,@PathVariable(value="transactionId") String transactionId)  {
		TransactionResponse response=service.transactionDetail(bankAccountId,transactionId);
		return new ResponseEntity<TransactionResponse>(response,HttpStatus.OK);
	}
	// 5 (Ready for Token)
	@RequestMapping(value="/accounts/{bankAccountId}/destinations",method=RequestMethod.GET)
	public ResponseEntity<TransferDestinations> destinations(@PathVariable(value="bankAccountId") String bankAccountId)  {
		TransferDestinations dest=service.destinations();
		return new ResponseEntity<TransferDestinations>(dest,HttpStatus.OK);
	}

	// 6
	@RequestMapping(value="/accounts/{bankAccountId}/details",method=RequestMethod.GET)
	public ResponseEntity<AccountDetails> details(@PathVariable(value="bankAccountId") String bankAccountId)  {
		AccountDetails response=service.accountDetails(bankAccountId);
		return new ResponseEntity<AccountDetails>(response,HttpStatus.OK);
	}

	// 7
	@RequestMapping(value="/accounts/{bankAccountId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> unlink(@PathVariable(value="bankAccountId") String bankAccountId)  {

		HttpStatus response=service.unlink();
		return new ResponseEntity<String>("",HttpStatus.OK);
	}



    ////// DELETE THIS
	@RequestMapping(value="/getAccountsList",method=RequestMethod.GET)
	public ResponseEntity<String> getAccounts(@ModelAttribute HttpHeaders headers)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}


}

