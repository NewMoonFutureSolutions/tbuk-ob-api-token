package com.tbuk.psd2.util;

import com.tbuk.psd2.model.account.response.TransactionResponse;
import com.tbuk.psd2.model.storage.request.Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CONSTANTS {

    public static String BANKID="TBUK";

    public static ConcurrentHashMap<String, Entry> entries=new ConcurrentHashMap<>();

    public static HashMap<String,String> INFOMAP=new HashMap<>();

    public static ConcurrentHashMap<String, TransactionResponse> COSTUMER1TRANSACTIONS=new ConcurrentHashMap<>();

    public static HashMap<String,String> TnxTransferMap=new HashMap<>();

    public static int transactionId=0;


}
