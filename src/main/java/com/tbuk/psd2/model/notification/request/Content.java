
package com.tbuk.psd2.model.notification.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "title",
    "body",
    "payload",
    "locKey",
    "locArgs",
    "createdAt"
})
public class Content {

    @JsonProperty("type")
    public String type;
    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
    @JsonProperty("payload")
    public String payload;
    @JsonProperty("locKey")
    public String locKey;
    @JsonProperty("locArgs")
    public List<String> locArgs = null;
    @JsonProperty("createdAt")
    public String createdAt;

}
