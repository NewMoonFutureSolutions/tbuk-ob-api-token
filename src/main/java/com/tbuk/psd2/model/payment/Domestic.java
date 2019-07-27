
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bic",
    "account"
})
public class Domestic {

    @JsonProperty("bank_code")
    public String bank_code;
    @JsonProperty("account_number")
    public String account;
    @JsonProperty("country")
    public String country;

}
