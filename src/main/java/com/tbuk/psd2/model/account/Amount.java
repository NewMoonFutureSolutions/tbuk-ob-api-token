package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"currency",
"value"
})
@Data
@Builder
public class Amount {

@JsonProperty("currency")
public String currency;
@JsonProperty("value")
public String value;

}