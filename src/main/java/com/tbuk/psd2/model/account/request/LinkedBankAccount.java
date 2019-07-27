
package com.tbuk.psd2.model.account.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.CustomAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountType",
    "account"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedBankAccount {

    @JsonProperty("accountType")
    public String accountType;
    @JsonProperty("account")
    public CustomAccount account;

}
