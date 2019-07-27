
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "value"
})
@Data
public class TransactionAmount {

    @JsonProperty("currency")
    public String currency;
    @JsonProperty("value")
    public String value;

}
