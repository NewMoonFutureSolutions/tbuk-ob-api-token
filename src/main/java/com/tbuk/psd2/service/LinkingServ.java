package com.tbuk.psd2.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.tbuk.psd2.model.account.response.*;
import com.tbuk.psd2.model.linking.AuthorizationResponse;
import com.tbuk.psd2.model.linking.NoopMethod;
import com.tbuk.psd2.model.linking.PlaintextBankAuthorization;
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
    private String jwtToken="";
    // 1 - account post for link info
    public AuthorizationResponse authorisationResponse(String accessToken) throws Exception{
        jwtToken=accessToken;
       return AuthorizationResponse.builder().bankId(CONSTANTS.BANKID).sealedMessage(getAccounts()).build();
    }

    private List<SealedMessage> getAccounts() throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        // Bu iki banka hesabinin json haline getirdim
        String bankAccount1_AsJson = mapper.writeValueAsString(getPlaintextBankAuthorization(1));
        System.out.println(bankAccount1_AsJson);
        String encodedString = Base64.getEncoder().encodeToString(bankAccount1_AsJson.getBytes());
        // simdi yukardaki hesaplari sealed message icine atacagiz. Her account u sealed mesaj ile ortecegiz
        List<SealedMessage> listSealedMessages=new ArrayList<>();
        listSealedMessages.add(SealedMessage.builder().NoopMethod(new NoopMethod()).ciphertext(encodedString).build());

        return listSealedMessages;

    }

    private PlaintextBankAuthorization getPlaintextBankAuthorization(int op) throws Exception{
        String memberId=getMemberId();
        return PlaintextBankAuthorization.builder().account(getBankAccount(1))
                .account_name("GBP Current Account (7883)")
                .expiration_ms(500000)
                .member_id(memberId)
                .build();

    }
    private String getMemberId() throws Exception{
        String private_jsonObject="{\"kty\":\"OKP\",\"d\":\"jXU4ZZUnqnNmDAwtm_0tpse80erzQfADBZIpgXczI70\",\"crv\":\"Ed25519\",\"x\":\"GGo29vo73dE296fO8-PT3ywf-clI3KBjS0_3DoKvYm4\"}";
        OctetKeyPair jwk=OctetKeyPair.parse(private_jsonObject);
        OctetKeyPair publicJWK = jwk.toPublicJWK();
        JWSObject jwsObject=JWSObject.parse(jwtToken);
        String line=jwsObject.getPayload().toString();
        String[] str=line.split(";");
        String[] str2=str[1].split("=");
        return str2[1];
    }
    private  BankAccount getBankAccount(int op){
        // tum cakma banka hesaplarini DummyResponses da topladim.. sen buraya gercek implementasyon yapacaksin
        return BankAccount.builder().custom(Custom.builder().bankId(CONSTANTS.BANKID).payload(CONSTANTS.INFOMAP.get("customer1.account1.tbukID")).build()).build();

    }




}
