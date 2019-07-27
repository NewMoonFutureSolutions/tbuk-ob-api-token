
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.scheme.FPS;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "swift"
})
public class Source {

    @JsonProperty("swift")
    public Swift swift;
    @JsonProperty("fps")
    public FPS fps;

}
