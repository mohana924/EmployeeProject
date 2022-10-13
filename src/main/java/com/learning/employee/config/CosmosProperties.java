package com.learning.employee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cosmosdb")
public class CosmosProperties {

	private String uri;

	private String key;

	private String secondaryKey;

	private boolean queryMetricsEnabled;

	public CosmosProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecondaryKey() {
		return secondaryKey;
	}

	public void setSecondaryKey(String secondaryKey) {
		this.secondaryKey = secondaryKey;
	}

	public boolean isQueryMetricsEnabled() {
		return queryMetricsEnabled;
	}

	public void setQueryMetricsEnabled(boolean queryMetricsEnabled) {
		this.queryMetricsEnabled = queryMetricsEnabled;
	}

}
