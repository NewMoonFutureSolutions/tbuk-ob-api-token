
package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BankAccount {

    @JsonProperty("swift")
    public Swift swift;
    @JsonProperty("fps")
    public Swift fps;
    @JsonProperty("custom")
    public Custom custom;
    @JsonProperty("iban")
    public Iban iban;


}
