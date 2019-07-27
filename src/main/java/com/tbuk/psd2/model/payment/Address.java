
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "houseNumber",
    "street"
})
@Builder
@Data
public class Address {

    @JsonProperty("houseNumber")
    public String houseNumber;
    @JsonProperty("street")
    public String street;

}
