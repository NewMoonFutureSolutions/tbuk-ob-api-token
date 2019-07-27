
package com.tbuk.psd2.model.account.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offset",
    "transactions"
})
@Data
@Builder
public class TransactionsPageResponse {

    @JsonProperty("offset")
    public String offset;
    @JsonProperty("transactions")
    public List<TransactionResponse> transactions;

}
