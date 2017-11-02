package com.imatz.devops.jenkins.github.bridge.dlg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.imatz.devops.jenkins.github.bridge.model.to.PostGihtubWebhookRequest;
import com.imatz.toto.util.rest.Credentials;
import com.imatz.toto.util.rest.RESTCall;

/**
 * Class to receive the push notification from GitHub that something has been
 * pushed on a project
 * 
 * @author C308961
 *
 */
@Service
public class PostGihtubWebhookDelegate {
	
	@Value("${jenkins.url.start.job}")
	private String jenkinsUrlStartJob_;
	
	@Value("${jenkins.credentials.user}")
	private String jenkinsUser_;
	
	@Value("${jenkins.credentials.password}")
	private String jenkinsPswd_;
	
	public void postGithubWekbook(PostGihtubWebhookRequest request) {
		
		RESTCall jenkinsJobCall = new RESTCall(jenkinsUrlStartJob_ + buildJobName(request.getRepository().getName()) + "/build?token=" + buildToken(request.getRepository().getName()));
		
		Credentials credentials = new Credentials();
		credentials.setUsername(jenkinsUser_);
		credentials.setPassword(jenkinsPswd_);
		
		jenkinsJobCall.setCredentials(credentials);
		jenkinsJobCall.call("", "POST");
	}

	/**
	 * Retrieves the token for the specified repository name
	 * @param githubRepositoryName
	 * @return
	 */
	private String buildToken(String githubRepositoryName) {

		return githubRepositoryName + "-token";
	}

	/**
	 * Builds the name of the job based on the repository name
	 * @param githubRepositoryName
	 * @return
	 */
	private String buildJobName(String githubRepositoryName) {

		return "build-" + githubRepositoryName;
	}

}
