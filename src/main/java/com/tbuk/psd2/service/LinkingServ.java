package com.tbuk.psd2.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbuk.psd2.model.account.response.*;
import com.tbuk.psd2.model.linking.AuthorizationResponse;
import com.tbuk.psd2.model.linking.NoopMethod;
import com.tbuk.psd2.model.linking.SealedMessage;
import com.tbuk.psd2.model.payment.BankAccount;
import com.tbuk.psd2.model.payment.Custom;
import com.tbuk.psd2.model.payment.CustomPayload;
import com.tbuk.psd2.util.CONSTANTS;
import com.tbuk.psd2.util.DummyResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Service
public class LinkingServ {

    @Autowired
    private Environment env;

    // 1 - account post for link info
    public AuthorizationResponse authorisationResponse(String accessToken) throws Exception{
       return AuthorizationResponse.builder().bankId(CONSTANTS.BANKID).sealedMessage(getAccounts()).build();
    }

    private List<SealedMessage> getAccounts() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        // Bu iki banka hesabinin json haline getirdim
        String bankAccount1_AsJson = mapper.writeValueAsString(getBankAccount(1));
        String encodedString = Base64.getEncoder().encodeToString(bankAccount1_AsJson.getBytes());
        // simdi yukardaki hesaplari sealed message icine atacagiz. Her account u sealed mesaj ile ortecegiz
        List<SealedMessage> listSealedMessages=new ArrayList<>();
        listSealedMessages.add(SealedMessage.builder().NoopMethod(new NoopMethod()).ciphertext(encodedString).build());

        return listSealedMessages;

    }

    private  BankAccount getBankAccount(int op){
        // tum cakma banka hesaplarini DummyResponses da topladim.. sen buraya gercek implementasyon yapacaksin
        return BankAccount.builder().custom(Custom.builder().bankId(CONSTANTS.BANKID).payload(CONSTANTS.INFOMAP.get("customer1.account1.tbukID")).build()).build();

    }




}
