package com.learning.employee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;

@Configuration
@EnableConfigurationProperties(CosmosProperties.class)
public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(AzureCosmosDbConfiguration.class);

	@Autowired
	private CosmosProperties properties;

	@Bean
	public CosmosClientBuilder cosmosClientBuilder() {
		DirectConnectionConfig directConnectionConfig = DirectConnectionConfig.getDefaultConfig();
		return new CosmosClientBuilder().endpoint(properties.getUri()).key(properties.getKey())
				.directMode(directConnectionConfig);
	}

	@Bean
	public CosmosConfig cosmosConfig() {
		return CosmosConfig.builder().responseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation())
				.enableQueryMetrics(properties.isQueryMetricsEnabled()).build();
	}

	@Override
	protected String getDatabaseName() {
		return "Employee";
	}

	private static class ResponseDiagnosticsProcessorImplementation implements ResponseDiagnosticsProcessor {

		@Override
		public void processResponseDiagnostics(@Nullable ResponseDiagnostics responseDiagnostics) {
			logger.info("Response Diagnostics {}", responseDiagnostics);
		}
	}

}
