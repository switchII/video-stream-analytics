package com.alinesno.cloud.vision.stream.controller.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author LuoAnDong
 * @date 2020年12月18日 上午11:12:39
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProviderConfig {

	private String acks ; 
	private int batchSize ; 
	private List<String> bootstrapServers ; 
	private String compressionType ; 
	private int lingerMs ; 
	private int maxRequestSize ; 
	private int retries ; 
	private String topic ;
	public String getAcks() {
		return acks;
	}
	public void setAcks(String acks) {
		this.acks = acks;
	}
	
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public List<String> getBootstrapServers() {
		return bootstrapServers;
	}
	public void setBootstrapServers(List<String> bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}
	public String getCompressionType() {
		return compressionType;
	}
	public void setCompressionType(String compressionType) {
		this.compressionType = compressionType;
	}
	public int getLingerMs() {
		return lingerMs;
	}
	public void setLingerMs(int lingerMs) {
		this.lingerMs = lingerMs;
	}
	public int getMaxRequestSize() {
		return maxRequestSize;
	}
	public void setMaxRequestSize(int maxRequestSize) {
		this.maxRequestSize = maxRequestSize;
	}
	public int getRetries() {
		return retries;
	}
	public void setRetries(int retries) {
		this.retries = retries;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	} 
	
}
