
package com.tbuk.psd2.model.notification.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value"
})
public class HandlerInstruction {

    @JsonProperty("key")
    public String key;
    @JsonProperty("value")
    public String value;

}
