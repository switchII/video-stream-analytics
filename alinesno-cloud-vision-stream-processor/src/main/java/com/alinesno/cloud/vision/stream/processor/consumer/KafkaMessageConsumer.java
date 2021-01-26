package com.alinesno.cloud.vision.stream.processor.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alinesno.cloud.vision.stream.processor.priperties.VideoEventData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class KafkaMessageConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaMessageConsumer.class) ; 

    public static final String topic = "camera_topic";
    
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
	@KafkaListener(topics = topic , groupId = "1")
    public void consumer(ConsumerRecord<String , String> consumerRecord) {
	
		log.debug("message = {}" , topic);
		
        Optional<String> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMassage.isPresent()) {
            String o = kafkaMassage.get();
            VideoEventData data = gson.fromJson(o, VideoEventData.class) ; 
            log.debug("data = {}" , data);
        }
        log.debug("收到消息 , offset : {} , kafkaMassage.isPresent():{} ", consumerRecord.offset() , kafkaMassage.isPresent()) ; 
    }

}