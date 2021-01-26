package com.alinesno.cloud.vision.stream.controller.collector;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.alinesno.cloud.vision.stream.controller.StreamControllerApplication;
import com.alinesno.cloud.vision.stream.controller.properties.CameraConfig;
import com.alinesno.cloud.vision.stream.controller.properties.KafkaProviderConfig;

@Component
@Configuration
@ConditionalOnBean({KafkaProviderConfig.class , CameraConfig.class})
public class VideoKafkaController {

	private static final Logger logger = Logger.getLogger(StreamControllerApplication.class);

	@Autowired
	private KafkaProviderConfig prop;

	@Autowired
	private CameraConfig camera;

	public void initKafka() throws Exception {
		// set producer properties
		Properties properties = new Properties();
		properties.put("bootstrap.servers", prop.getBootstrapServers()); // .getProperty("kafka.bootstrap.servers"));
		properties.put("acks", prop.getAcks()); // .getProperty("kafka.acks"));
		properties.put("retries", prop.getRetries()); // .getProperty("kafka.retries"));
		properties.put("batch.size", prop.getBatchSize()); // .getProperty("kafka.batch.size"));
		properties.put("linger.ms", prop.getLingerMs()); // .getProperty("kafka.linger.ms"));
		properties.put("max.request.size", prop.getMaxRequestSize()); // .getProperty("kafka.max.request.size"));
		properties.put("compression.type", prop.getCompressionType()); // .getProperty("kafka.compression.type"));
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// generate event
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		generateIoTEvent(producer, prop.getTopic(), camera.getId(), camera.getUrls());
	}

	private void generateIoTEvent(Producer<String, String> producer, String topic, List<String> ids, List<String> urls) throws Exception {

		if (urls.size() != ids.size()) {
			throw new Exception("There should be same number of camera Id and url");
		}

		logger.info("Total urls to process " + urls.size());

		for (int i = 0; i < urls.size(); i++) {
			Thread t = new Thread(new VideoEventGenerator(ids.get(i).trim(), urls.get(i).trim(), producer, topic));
			t.start();
		}
	}
}
