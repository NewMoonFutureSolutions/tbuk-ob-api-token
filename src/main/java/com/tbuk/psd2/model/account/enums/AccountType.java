package com.tbuk.psd2.model.account.enums;

public enum AccountType {

    CHECKING("CHECKING");

    private String type;
    AccountType(String type){this.type=type;}
    public String getAccountType(){return this.type;}
}
