package com.alinesno.cloud.vision.stream.controller.collector;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alinesno.cloud.vision.stream.controller.StreamCollectorApplication;
import com.alinesno.cloud.vision.stream.controller.properties.CameraConfig;

@Component
@Configuration
@ConditionalOnBean(CameraConfig.class)
public class VideoKafkaController {

	private static final Logger logger = Logger.getLogger(StreamCollectorApplication.class);

//	@Autowired
//	private KafkaProviderConfig prop;

	@Autowired
	private CameraConfig camera;

	private String topic = "camera_topic" ; 
		
	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate;
		 
	public void initKafka() throws Exception {
		generateIoTEvent(kafkaTemplate, topic , camera.getId(), camera.getUrls());
	}

	private void generateIoTEvent(KafkaTemplate<String , String> kafkaTemplate, String topic, List<String> ids, List<String> urls) throws Exception {

		if (urls.size() != ids.size()) {
			throw new Exception("There should be same number of camera Id and url");
		}

		logger.info("Total urls to process " + urls.size());

		for (int i = 0; i < urls.size(); i++) {
			Thread t = new Thread(new VideoEventGenerator(ids.get(i).trim(), urls.get(i).trim(), kafkaTemplate, topic));
			t.start();
		}
	}
}
