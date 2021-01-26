package com.alinesno.cloud.vision.stream.controller.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 视频流
 * 
 * @author LuoAnDong
 * @date 2021年1月26日 下午3:39:12
 */
@Configuration
@ConfigurationProperties(prefix = "camera")
public class CameraConfig {

	private List<String> id ; 
	private List<String> urls ;
	
	public List<String> getId() {
		return id;
	}
	public void setId(List<String> id) {
		this.id = id;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	} 

}
