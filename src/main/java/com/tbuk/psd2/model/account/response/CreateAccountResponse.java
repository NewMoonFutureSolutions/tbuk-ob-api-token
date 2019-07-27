package com.tbuk.psd2.model.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountId"
})
@Data
@Builder
public class CreateAccountResponse {

@JsonProperty("accountId")
public String accountId;

}