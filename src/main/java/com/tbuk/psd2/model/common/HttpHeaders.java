package com.tbuk.psd2.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpHeaders {
    private String Authorization;
    private String audience;
    private String client_Id;
    private String content_Type;
    private String x_fapi_customer_ip_address;
    private String nonce;

}
