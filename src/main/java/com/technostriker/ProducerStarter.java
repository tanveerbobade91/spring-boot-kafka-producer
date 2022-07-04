
package com.technostriker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerStarter implements CommandLineRunner{
	public static final Logger logger=LoggerFactory.getLogger(ProducerStarter.class);

	  
	@Autowired
	public KafkaTemplate<String, String> template;
    public static void main(String[] args) {
        SpringApplication.run(ProducerStarter.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		     for (int i = 0; i < 100; i++) {
				
		    	
		            template.send("my-kafka-topic", "test "+i);
		            logger.info("Producer Sending Message {}", "test "+i);
		            Thread.sleep(60);
		            
		     }
		       
		    }
		
	}

//    @Bean
//    public NewTopic  topic() {
//        return TopicBuilder.name("topic1")
//                .partitions(10)
//                .replicas(1)
//                .build();
//    }

  

  
