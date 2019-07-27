package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "supports_information","supports_send_payment"
})
public class AccountFeatures {

    @JsonProperty("supports_information")
    private boolean supports_information;//" - AIS Flow
    @JsonProperty("supports_send_payment")
    private boolean supports_send_payment;// - PIS Flow
    //private boolean supports_receive_payment" - P2P capabilities (optional)
}
