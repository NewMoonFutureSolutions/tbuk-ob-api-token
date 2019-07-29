package com.tbuk.psd2.model.linking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tbuk.psd2.model.payment.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaintextBankAuthorization {

    @JsonProperty("member_id")
    String member_id;
    @JsonProperty("account_name")
    String account_name; //"Checking account with # ending 5678"
    @JsonProperty("account")
    BankAccount account;// // Account info by some method, e.g., SEPA
    @JsonProperty("expiration_ms")
    int expiration_ms; // Expiration time

}
