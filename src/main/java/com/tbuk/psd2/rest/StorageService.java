package com.tbuk.psd2.rest;

// READY

import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.model.storage.request.Entry;
import com.tbuk.psd2.model.storage.response.EntryResponse;
import com.tbuk.psd2.model.storage.response.EntryUpdated;
import com.tbuk.psd2.service.ConsentServ;
import com.tbuk.psd2.service.StorageServ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/storage",description="Linking Service",produces ="application/json")
public class StorageService {
 
	@Autowired
    StorageServ service;
  	
	@RequestMapping(value="/storage/entries",method=RequestMethod.PUT)
	public ResponseEntity<EntryUpdated> putEntry(@RequestBody Entry entry)  {
        EntryUpdated resp=service.doEntry(entry);
		return new ResponseEntity<EntryUpdated>(resp,HttpStatus.OK);
	}

    @RequestMapping(value="/storage/entries/{key}",method=RequestMethod.PUT)
    public ResponseEntity<EntryResponse> getEntry(@PathVariable(value="key") String key)  {
        EntryResponse resp=service.getEntryResponse(key);
        return new ResponseEntity<EntryResponse>(resp,HttpStatus.OK);
    }

    @RequestMapping(value="/storage/entries/{keyToDelete}",method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteEntry(@PathVariable(value="keyToDelete") String keyToDelete)  {
        service.deleteEntry(keyToDelete);
        return new ResponseEntity<String>("Deleted",HttpStatus.NO_CONTENT);
    }



}

