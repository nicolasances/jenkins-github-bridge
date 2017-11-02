package com.imatz.devops.jenkins.github.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imatz.devops.jenkins.github.bridge.dlg.PostGihtubWebhookDelegate;
import com.imatz.devops.jenkins.github.bridge.model.to.PostGihtubWebhookRequest;

@RestController
public class JenkinsGithubBridgeController {
	
	@Autowired
	private PostGihtubWebhookDelegate postGihtubWebhookDelegate_;
	
	@RequestMapping(value = "/webhook", method = RequestMethod.POST, consumes = "application/json")
	public void postWebhook(@RequestBody PostGihtubWebhookRequest request) {
		
		postGihtubWebhookDelegate_.postGithubWekbook(request);
	}
	
	@RequestMapping(value = "/smoke", method = RequestMethod.GET)
	public String smoke() {
		
		return "It's working";
	}

}
