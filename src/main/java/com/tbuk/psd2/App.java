package com.tbuk.psd2;

import java.time.LocalDateTime;

import com.tbuk.psd2.model.account.Amount;
import com.tbuk.psd2.model.account.response.TransactionResponse;
import com.tbuk.psd2.util.CONSTANTS;
import com.tbuk.psd2.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/// This is the main Spring Boot application - converted into web servlet to make it web app deployable
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.tbuk.psd2")
public class App  {
	static Logger logger = LoggerFactory.getLogger(App.class);
	 public static void main(String[] args) throws InterruptedException  {
	     // Load the fake bank account, customer info /// Delete after real implementation
       LoadData();
      ApplicationContext context = SpringApplication.run(App.class, args);
      logger.info("TBUK PSD2 Services started "+LocalDateTime.now());
      Thread.sleep(5000);
  }

  private static void LoadData(){
	 // Customer 1
      CONSTANTS.INFOMAP.put("customer1.name","Test");
      CONSTANTS.INFOMAP.put("customer1.lastname","User");
      CONSTANTS.INFOMAP.put("customer1.address","");
      // Account 1
      CONSTANTS.INFOMAP.put("customer1.account1.tbukID","08347883");
      CONSTANTS.INFOMAP.put("customer1.account1.sortcode","405198");
      CONSTANTS.INFOMAP.put("customer1.account1.accountNumber","08347883");
      CONSTANTS.INFOMAP.put("customer1.account1.bic","TUBAGB2L");
      CONSTANTS.INFOMAP.put("customer1.account1.iban","GB95TUBA40519808347883");

      LoadTransactions();
  }

  private static void LoadTransactions(){
      CONSTANTS.transactionId++;
      TransactionResponse.builder().id(String.valueOf(CONSTANTS.transactionId))
               .amount(Amount.builder().currency("GBP").value("800").build())
              .createdAt(Utils.getDateNowInFormat1())
                                   .description("Room rent")
              .status("PROCESSING")
              .type("DEBIT")
              .tokenId("1")
              .tokenTransferId("1").build();


	    // CONSTANTS.COSTUMER1TRANSACTIONS.put()
  }

	  
}
