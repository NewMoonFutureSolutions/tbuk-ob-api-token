
package com.tbuk.psd2.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "houseNumber",
    "houseName",
    "flats",
    "conscriptionNumber",
    "street",
    "place",
    "postCode",
    "city",
    "country",
    "full",
    "hamlet",
    "suburb",
    "subdistrict",
    "district",
    "province",
    "state"
})
@Data
@Builder
public class Address {

    @JsonProperty("houseNumber")
    public String houseNumber;
    @JsonProperty("houseName")
    public String houseName;
    @JsonProperty("flats")
    public String flats;
    @JsonProperty("conscriptionNumber")
    public String conscriptionNumber;
    @JsonProperty("street")
    public String street;
    @JsonProperty("place")
    public String place;
    @JsonProperty("postCode")
    public String postCode;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("full")
    public String full;
    @JsonProperty("hamlet")
    public String hamlet;
    @JsonProperty("suburb")
    public String suburb;
    @JsonProperty("subdistrict")
    public String subdistrict;
    @JsonProperty("district")
    public String district;
    @JsonProperty("province")
    public String province;
    @JsonProperty("state")
    public String state;

}
