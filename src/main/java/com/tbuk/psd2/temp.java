package com.tbuk.psd2;

import java.io.IOException;

import com.tbuk.psd2.model.linking.SealedMessage;
import com.tbuk.psd2.util.StatementBase64Utils;
import io.token.proto.banklink.Banklink;
import io.token.proto.common.security.SecurityProtos;

public class temp {

	public static void main(String[] args) throws IOException {
//		BankAccount b=BankAccount.builder().accountNo("1")
//				                           .accountType(AccountType.PERSONAL)
//				                           .bicCode("bic")
//				                           .currency(Currency.GBP)
//				                           .iban("iban")
//				                           .sortCode("010101")
//				                           .build();
//		
//		Charge c=new Charge();
//		c.setAmount(10);
//		c.setText("");
//		
//		Charge c2=new Charge(10,"");
//		
//		Charge c3=Charge.builder().amount(10).build();
//		
//		 ObjectMapper mapper = new ObjectMapper();
//		 String dtoAsString = mapper.writeValueAsString(b);
//	
//	  System.out.println(dtoAsString);
		System.out.println(StatementBase64Utils.convertToBase64("/Users/borauzun/Desktop/statement1.pdf"));

	}
	
	

}
