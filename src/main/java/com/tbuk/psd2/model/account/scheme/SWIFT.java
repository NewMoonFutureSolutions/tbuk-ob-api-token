package com.tbuk.psd2.model.account.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bic","accountNumber"})
@Data
@Builder
public class SWIFT {
    private String accountNumber;
    private String bic;
}
