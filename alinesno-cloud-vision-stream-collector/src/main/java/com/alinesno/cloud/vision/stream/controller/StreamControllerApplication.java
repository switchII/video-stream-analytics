package com.alinesno.cloud.vision.stream.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 视频分析输入，然后输入到kafka中
 * 
 * @author LuoAnDong
 * @date 2021年1月26日 下午3:15:03
 */
@SpringBootApplication
public class StreamControllerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamControllerApplication.class, args);
	}

}
