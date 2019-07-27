package com.tbuk.psd2.model.payment.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.common.TransactionStatus;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"transactionId",
"status",
"statusDescription"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {

@JsonProperty("transactionId")
public String transactionId;
@JsonProperty("status")
public String status;
@JsonProperty("statusDescription")
public String statusDescription;


}