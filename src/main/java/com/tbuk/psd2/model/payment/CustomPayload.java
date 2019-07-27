
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"sortcode","accountnumber","tbukid"})
@Builder
@Data
public class CustomPayload {

    @JsonProperty("sortcode")
    public String sortcode;
    @JsonProperty("accountnumber")
    public String accountnumber;
    @JsonProperty("tbukid")
    public String tbukid;
}
