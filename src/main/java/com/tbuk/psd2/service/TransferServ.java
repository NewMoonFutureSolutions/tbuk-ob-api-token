package com.tbuk.psd2.service;

import com.tbuk.psd2.model.account.Amount;
import com.tbuk.psd2.model.account.response.TransactionResponse;
import com.tbuk.psd2.model.common.TransactionStatus;
import com.tbuk.psd2.model.payment.request.PaymentRequest;
import com.tbuk.psd2.model.payment.response.PaymentResponse;
import com.tbuk.psd2.util.CONSTANTS;
import com.tbuk.psd2.util.Utils;
import org.springframework.stereotype.Service;


@Service
public class TransferServ {

    public PaymentResponse transfer(PaymentRequest paymentRequest){

        // add this txn into hash table temp ( daha sonra sorarlarsa diye hashtable a kaydedelim)
        CONSTANTS.transactionId++;
        String txnId=String.valueOf(CONSTANTS.transactionId);
        TransactionResponse tr=TransactionResponse.builder().id(String.valueOf(CONSTANTS.transactionId))
                .amount(Amount.builder().currency("GBP").value("800").build())
                .createdAt(Utils.getDateNowInFormat1())
                .description("Room rent")
                .status(TransactionStatus.SUCCESS.getStatus())
                .type("DEBIT")
                .tokenId("1") // boyle bir bilgi gondermiyorlar
                .tokenTransferId(paymentRequest.transferId).build();

        CONSTANTS.COSTUMER1TRANSACTIONS.put(txnId,tr);

        CONSTANTS.TnxTransferMap.put(paymentRequest.transferId,txnId); // they ask for transferId in transfer service, txnid in account

       return PaymentResponse.builder().transactionId(txnId)
                .status(TransactionStatus.PROCESSING.getStatus()).statusDescription("Received by TBUK").build();
    }

    // su anki hali eger transfer servisten gonderilmisse PROCESSING diye yaziyor.
    public String getTransferStatus(String transferId){
        if(CONSTANTS.TnxTransferMap.containsKey(transferId)) {
            String txnId=CONSTANTS.TnxTransferMap.get(transferId);
            return "PROCESSING";
        }
        else{return "The specified transfer was not found.";}
    }
}
