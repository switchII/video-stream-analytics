package com.alinesno.cloud.vision.stream.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.alinesno.cloud.vision.stream.controller.collector.VideoKafkaController;
import com.alinesno.cloud.vision.stream.controller.utils.SpringContextUtil;

/**
 * 视频分析输入，然后输入到kafka中
 * 
 * @author LuoAnDong
 * @date 2021年1月26日 下午3:15:03
 */
@SpringBootApplication
public class StreamCollectorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamCollectorApplication.class, args);

	}

	@Component
	class CommandLineRunnerImpl implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			System.out.println("通过实现CommandLineRunner接口，在spring boot项目启动后打印参数");
			VideoKafkaController videoKafkaController = SpringContextUtil.getBean(VideoKafkaController.class);
			videoKafkaController.initKafka();
		}
	}
}
