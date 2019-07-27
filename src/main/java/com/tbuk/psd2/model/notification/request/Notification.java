
package com.tbuk.psd2.model.notification.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "notificationId",
    "subscriber",
    "content",
    "status"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @JsonProperty("notificationId")
    public String notificationId;
    @JsonProperty("subscriber")
    public Subscriber subscriber;
    @JsonProperty("content")
    public Content content;
    @JsonProperty("status")
    public List<Object> status;

}
