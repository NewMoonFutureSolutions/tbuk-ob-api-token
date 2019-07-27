
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "account",
    "customerData"
})
@Data
public class Destination {

    @JsonProperty("account")
    public BankAccount account;
    @JsonProperty("customerData")
    public CustomerData customerData;

}
