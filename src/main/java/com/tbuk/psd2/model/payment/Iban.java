
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bic",
    "account"
})
public class Iban {

    @JsonProperty("bic")
    public String bic;
    @JsonProperty("iban")
    public String iban;

}
