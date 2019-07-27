package com.tbuk.psd2.model.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.Amount;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"type",
"status",
"amount",
"description",
"tokenId",
"tokenTransferId",
"createdAt"
})
@Data
@Builder
public class TransactionResponse {

@JsonProperty("id")
public String id;
@JsonProperty("type")
public String type;
@JsonProperty("status")
public String status;
@JsonProperty("amount")
public Amount amount;
@JsonProperty("description")
public String description;
@JsonProperty("tokenId")
public String tokenId;
@JsonProperty("tokenTransferId")
public String tokenTransferId;
@JsonProperty("createdAt")
public String createdAt;

}