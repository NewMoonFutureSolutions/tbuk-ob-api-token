
package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bankId",
    "payload"
})
public class CustomAccount {

    @JsonProperty("bankId")
    public String bankId;
    @JsonProperty("payload")
    public String payload;

}
