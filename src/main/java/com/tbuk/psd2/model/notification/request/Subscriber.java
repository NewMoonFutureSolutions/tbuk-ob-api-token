
package com.tbuk.psd2.model.notification.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "subscriberId",
    "handler",
    "handlerInstructions"
})
public class Subscriber {

    @JsonProperty("subscriberId")
    public String subscriberId;
    @JsonProperty("handler")
    public String handler;
    @JsonProperty("handlerInstructions")
    public List<HandlerInstruction> handlerInstructions = null;

}
