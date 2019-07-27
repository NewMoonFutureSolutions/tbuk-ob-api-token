
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bic",
    "account"
})
@Builder
@Data
public class Custom {

    @JsonProperty("bankId")
    public String bankId;
    @JsonProperty("payload")
    public String payload;

}
