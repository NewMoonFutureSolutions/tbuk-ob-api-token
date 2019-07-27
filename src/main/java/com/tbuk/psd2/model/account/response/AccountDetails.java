package com.tbuk.psd2.model.account.response;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tbuk.psd2.model.account.Entry;
import com.tbuk.psd2.model.account.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"identifier",
"accountType",
"status",
"metadata"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetails {

    @JsonProperty("identifier")
    public String identifier;
    @JsonProperty("accountType")
    public String accountType;
    @JsonProperty("status")
    public String status;
    @JsonProperty("metadata")
    public List<Entry> metadata=new ArrayList<>();
}