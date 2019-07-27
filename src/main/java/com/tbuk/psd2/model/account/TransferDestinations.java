
package com.tbuk.psd2.model.account;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destinations",
    "customerData"
})
@Data
@Builder
public class TransferDestinations {

    @JsonProperty("destinations")
    public List<Destination> destinations;
    @JsonProperty("customerData")
    public CustomerData customerData;

}
