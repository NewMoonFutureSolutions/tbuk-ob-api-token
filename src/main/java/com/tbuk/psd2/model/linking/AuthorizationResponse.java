package com.tbuk.psd2.model.linking;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bankId",
"sealedMessage"
})
@Builder
public class AuthorizationResponse {

@JsonProperty("bankId")
public String bankId;
@JsonProperty("sealedMessage")
public List<SealedMessage> sealedMessage = null;

}