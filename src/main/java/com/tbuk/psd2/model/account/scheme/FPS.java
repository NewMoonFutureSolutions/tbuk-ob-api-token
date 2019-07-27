package com.tbuk.psd2.model.account.scheme;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"sortCode","accountNumber"})
@Data
@Builder
public class FPS {
    private String sortCode;
    private String accountNumber;
}
