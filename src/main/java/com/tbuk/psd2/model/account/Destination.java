
package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.scheme.FPS;
import com.tbuk.psd2.model.account.scheme.SWIFT;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
@Data
@Builder
public class Destination {

private FPS FPS;
private SWIFT SWIFT;

}
