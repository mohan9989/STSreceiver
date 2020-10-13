package com.application.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {
	
	  @Autowired
	    private SenderApplication.PubsubOutboundGateway messagingGateway;
	  
	    @RequestMapping(value = "/publishmessage", method = RequestMethod.POST)
	    public String publishMessage(@RequestBody SenderMessage obj) {
	        messagingGateway.sendToPubsub(obj.getMessage().toString());
	        return "Message published to Google Pub/Sub successfully";
	    }

}
