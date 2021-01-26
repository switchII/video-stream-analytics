package com.alinesno.cloud.vision.stream.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import com.alinesno.cloud.vision.stream.controller.collector.VideoKafkaController;
import com.alinesno.cloud.vision.stream.controller.utils.SpringContextUtil;

@Component
@ConditionalOnBean(VideoKafkaController.class)
public class StartComponent implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("项目启动后即执行此方法！");
		
		VideoKafkaController videoKafkaController = SpringContextUtil.getBean(VideoKafkaController.class) ; 
		
		videoKafkaController.initKafka();
	}
}