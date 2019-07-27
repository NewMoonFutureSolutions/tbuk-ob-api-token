package com.tbuk.psd2.service;


import com.tbuk.psd2.model.account.Amount;
import com.tbuk.psd2.model.account.Destination;
import com.tbuk.psd2.model.account.TransferDestinations;
import com.tbuk.psd2.model.account.enums.AccountType;
import com.tbuk.psd2.model.account.request.LinkedBankAccount;
import com.tbuk.psd2.model.account.response.*;
import com.tbuk.psd2.model.account.scheme.FPS;
import com.tbuk.psd2.model.account.scheme.SWIFT;
import com.tbuk.psd2.util.CONSTANTS;
import com.tbuk.psd2.util.DummyResponses;
import com.tbuk.psd2.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service
public class AisService {

    @Autowired
    private Environment env;

    // 1 - account post for link info
    public CreateAccountResponse createAccountResponse(LinkedBankAccount linkedAccount){
       //String accountId=env.getProperty("");
        return CreateAccountResponse.builder().accountId(CONSTANTS.INFOMAP.get("customer1.account1.tbukID")).build();
    }

    // 2 - balance enquiry
    public BalanceResponse balance(){

        return BalanceResponse.builder().current(Amount.builder().currency("GBP").value("200.00").build())
                                         .available(Amount.builder().currency("GBP").value("200.00").build())
                                         .updatedAt(Utils.getDateNowInFormat1())
                              .build();
    }
    //3
    public TransactionsPageResponse transactions(){
        TransactionsPageResponse response=TransactionsPageResponse.builder().offset("1").build();

        //
        List<TransactionResponse> list=new ArrayList<>();
        Iterator it = CONSTANTS.COSTUMER1TRANSACTIONS.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            list.add((TransactionResponse) pair.getValue());
        }
        response.setTransactions(list);
       return response;
    }
    //4
    public TransactionResponse transactionDetail(String bankAccountId,String txnId){

        if(CONSTANTS.COSTUMER1TRANSACTIONS.containsKey(txnId)) {return CONSTANTS.COSTUMER1TRANSACTIONS.get(txnId);}
        // if not meaningfull then
        return TransactionResponse.builder().id("1")
                .amount(Amount.builder().currency("GBP").value("800").build())
                .createdAt(Utils.getDateNowInFormat1())
                .description("Room rent")
                .status("PROCESSING")
                .type("DEBIT")
                .tokenId("1")
                .tokenTransferId("1").build();
    }

    // 5 - destinations
    public TransferDestinations destinations(){
        List<Destination> destinations=new ArrayList<>();

        String accountNo=CONSTANTS.INFOMAP.get("customer1.account1.accountNumber");
        String sortcode=CONSTANTS.INFOMAP.get("customer1.account1.sortcode");
        String bic=CONSTANTS.INFOMAP.get("customer1.account1.bic");
        String iban=CONSTANTS.INFOMAP.get("customer1.account1.iban");

        destinations.add(Destination.builder().FPS(FPS.builder().accountNumber(accountNo).sortCode(sortcode).build()).build());
        destinations.add(Destination.builder().SWIFT(SWIFT.builder().accountNumber(iban).bic(bic).build()).build());

        return TransferDestinations.builder().destinations(destinations)
                                             .customerData(DummyResponses.customerData(1))
                                   .build();

    }
    // 6
    public AccountDetails accountDetails(String bankAccountId){
        AccountDetails resp= new AccountDetails();
        resp.setStatus("Active");
        resp.setAccountType(AccountType.CHECKING.getAccountType());
        resp.setIdentifier(CONSTANTS.INFOMAP.get("customer1.account1.tbukID"));
        resp.setMetadata(null);

        return resp;
    }
    // 7
    public HttpStatus unlink(){
        return HttpStatus.NO_CONTENT;
    }


}
