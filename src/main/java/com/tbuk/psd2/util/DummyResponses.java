package com.tbuk.psd2.util;

import com.tbuk.psd2.model.account.Address;
import com.tbuk.psd2.model.payment.BankAccount;
import com.tbuk.psd2.model.payment.Custom;
import com.tbuk.psd2.model.account.CustomerData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DummyResponses {

    public static CustomerData customerData(int op){
        switch(op){
            case 1:List<String> legalNames=new ArrayList<>();
                   legalNames.add(CONSTANTS.INFOMAP.get("customer1.name"));
                   legalNames.add(CONSTANTS.INFOMAP.get("customer1.lastname"));
                   return CustomerData.builder().legalNames(legalNames)
                           .address(Address.builder()
                           .houseNumber("61 T Court")
                           .street("Trabzon Street").postCode("W1 1AA").city("London").country("UK").build()).build();
            case 2:List<String> legalNames2=new ArrayList<>();
                legalNames2.add(CONSTANTS.INFOMAP.get("customer2.name"));
                legalNames2.add(CONSTANTS.INFOMAP.get("customer2.lastname"));
                return CustomerData.builder().legalNames(legalNames2)
                        .address(Address.builder()
                                .houseNumber("6161")
                                .street("Izmir Street").postCode("W2 1AA").city("London").country("UK").build()).build();
            default:return null;
        }

    }


}
