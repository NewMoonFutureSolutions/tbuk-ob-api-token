package com.tbuk.psd2.service;

import com.tbuk.psd2.model.storage.request.Entry;
import com.tbuk.psd2.model.storage.response.EntryResponse;
import com.tbuk.psd2.model.storage.response.EntryUpdated;
import com.tbuk.psd2.util.CONSTANTS;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StorageServ {

    public EntryUpdated doEntry(Entry e){

        String previousValue="";
        if(CONSTANTS.entries.containsKey(e.key)){
             Entry previousEntry=CONSTANTS.entries.get(e.key);
             previousValue=previousEntry.value;
             CONSTANTS.entries.replace(e.key,previousEntry,e);
        }
        else{
            CONSTANTS.entries.put(e.key,e);
        }

        return EntryUpdated.builder().previous(previousValue).build();
    }

    public EntryResponse getEntryResponse(String key){
        String val="";
        if(CONSTANTS.entries.containsKey(key)){
            Entry entry=CONSTANTS.entries.get(key);
            val=entry.value;
        }
        return EntryResponse.builder().key(key).value(val).build();
    }
    public void deleteEntry(String key){
        if(CONSTANTS.entries.containsKey(key)){
            CONSTANTS.entries.remove(key);
        }

    }
}
