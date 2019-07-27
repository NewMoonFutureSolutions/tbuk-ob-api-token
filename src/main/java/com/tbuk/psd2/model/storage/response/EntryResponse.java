package com.tbuk.psd2.model.storage.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"key",
"value"
})
@Builder
public class EntryResponse {

@JsonProperty("key")
public String key;
@JsonProperty("value")
public String value;

}