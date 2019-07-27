package com.tbuk.psd2.model.common;

import lombok.Data;

import java.util.List;

@Data
public class JWTPayload {

    //private List<BankAccount> listAccounts;
    private boolean aisp;
    private boolean pisp;
    private String tppId;
}
