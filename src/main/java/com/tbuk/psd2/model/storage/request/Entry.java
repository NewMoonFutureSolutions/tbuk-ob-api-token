
package com.tbuk.psd2.model.storage.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value",
    "category"
})
public class Entry {

    @JsonProperty("key")
    public String key;
    @JsonProperty("value")
    public String value;
    @JsonProperty("category")
    public String category;

}
