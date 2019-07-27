
package com.tbuk.psd2.model.account;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "legalNames",
    "address"
})
@Data
@Builder
public class CustomerData {

    @JsonProperty("legalNames")
    public List<String> legalNames = null;
    @JsonProperty("address")
    public Address address;

}
