package com.imatz.devops.jenkins.github.bridge.model.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostGihtubWebhookRequest {

	private Repository repository_;

	public Repository getRepository() {

		return repository_;
	}

	public void setRepository(Repository repository) {

		repository_ = repository;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Repository {

		/**
		 * Name of the repository. E.g. toto-ms-jobsearch
		 */
		private String name_;

		public String getName() {

			return name_;
		}

		public void setName(String name) {

			name_ = name;
		}
	}

}
