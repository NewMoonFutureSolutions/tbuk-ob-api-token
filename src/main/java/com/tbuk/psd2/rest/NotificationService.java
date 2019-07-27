package com.tbuk.psd2.rest;
// READY

import com.tbuk.psd2.model.notification.request.Notification;
import com.tbuk.psd2.service.ConsentServ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="/consents",description="Consent Service",produces ="application/json")
public class NotificationService {

	@RequestMapping(value="/notifications",method=RequestMethod.PUT)
	public ResponseEntity<String> notify(@RequestBody Notification notification)  {
		System.out.println("Notification given :"+notification.notificationId);
		System.out.println(notification.toString());
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value="/notifications/{notificationId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteNotification(@PathVariable(value="notificationId") String notificationId)  {
        System.out.println("Notification Invalidated :"+notificationId);
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	

}

