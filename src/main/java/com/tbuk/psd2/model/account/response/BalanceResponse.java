package com.tbuk.psd2.model.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.Amount;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"current",
"available",
"updatedAt"
})
@Data
@Builder
public class BalanceResponse {

@JsonProperty("current")
public Amount current;
@JsonProperty("available")
public Amount available;
@JsonProperty("updatedAt")
public String updatedAt;

}