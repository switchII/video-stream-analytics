package com.alinesno.cloud.vision.stream.processor.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaConsumerPropertiesExt extends KafkaProperties {

	private int concurrency;

	public int getConcurrency() {
		return concurrency;
	}

	public void setConcurrency(int concurrency) {
		this.concurrency = concurrency;
	}

}
