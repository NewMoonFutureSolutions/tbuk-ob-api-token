
package com.tbuk.psd2.model.payment.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.payment.Destination;
import com.tbuk.psd2.model.payment.RequestedAmount;
import com.tbuk.psd2.model.payment.Source;
import com.tbuk.psd2.model.payment.TransactionAmount;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transferId",
    "requestedAmount",
    "transactionAmount",
    "source",
    "destinations",
    "feeResponsibility",
    "description"
})
@Data
public class PaymentRequest {

    @JsonProperty("transferId")
    public String transferId;
    @JsonProperty("requestedAmount")
    public RequestedAmount requestedAmount;
    @JsonProperty("transactionAmount")
    public TransactionAmount transactionAmount;
    @JsonProperty("source")
    public Source source;
    @JsonProperty("destinations")
    public List<Destination> destinations;
    @JsonProperty("feeResponsibility")
    public String feeResponsibility;
    @JsonProperty("description")
    public String description;

}
