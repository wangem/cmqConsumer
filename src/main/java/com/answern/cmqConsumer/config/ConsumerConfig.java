package com.answern.cmqConsumer.config;

import com.answern.cmqConsumer.base.CmqQueueConsumerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 */
@SpringBootConfiguration
public class ConsumerConfig {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.queue.logger.name}")
	private String queueName;
	@Value("${spring.queue.logger.endpoint}")
	private String QUEUE_ENDPOINT;
	@Value("${spring.queue.logger.secretid}")
	private String CMQ_SECRETID;
	@Value("${spring.queue.logger.secretkey}")
	private String CMQ_SECRETKEY;

	@Bean
	public boolean initImageConsume() {
		logger.info("开启电子材料上传消费");
		CmqQueueConsumerImp consumerImp = new CmqQueueConsumerImp(QUEUE_ENDPOINT,CMQ_SECRETID,CMQ_SECRETKEY);
		consumerImp.setQueueName(queueName);
		consumerImp.initClient();
		return true;
	}
}
