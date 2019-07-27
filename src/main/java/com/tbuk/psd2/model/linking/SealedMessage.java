package com.tbuk.psd2.model.linking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ciphertext"
})
@Builder
public class SealedMessage {

@JsonProperty("ciphertext")
public String ciphertext;

@JsonProperty("NoopMethod")
NoopMethod NoopMethod;

@JsonProperty("RsaMethod")
RsaMethod rsaMethod;

}