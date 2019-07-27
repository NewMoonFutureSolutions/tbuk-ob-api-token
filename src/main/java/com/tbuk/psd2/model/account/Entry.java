package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"key",
"value"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entry {

@JsonProperty("key")
public String key;
@JsonProperty("value")
public String value;

}