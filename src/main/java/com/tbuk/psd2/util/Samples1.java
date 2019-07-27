package com.tbuk.psd2.util;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.time.LocalDateTime;

public class Samples1 {

    public static void main(String[] args) throws Exception {

        LocalDateTime now=LocalDateTime.now();
        System.out.println(now);

    }


     private static void printPayRequest(Object request) throws IOException{
         		 ObjectMapper mapper = new ObjectMapper();
   		         String paymentRequestAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
   		         System.out.println(paymentRequestAsString);
     }
}
