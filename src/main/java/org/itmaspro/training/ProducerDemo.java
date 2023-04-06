package org.itmaspro.training;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProducerDemo {

  private static final Logger logger = LogManager.getLogger(ProducerDemo.class);

  public static void main(String[] args) {
    // create producer Properties
    Properties properties = new Properties();
    // connect localhost
    // properties.setProperty("bootstrap.servers","127.0.0.1:9092");
    // connect conduktor Playground
    properties.setProperty("bootstrap.servers", "cluster.playground.cdkt.io:9092");
    properties.setProperty("security.protocol", "SASL_SSL");
    properties.setProperty(
        "sasl.jaas.config",
        "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"1slSUnubWdSEPpFS6o9bEn\" password=\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiIxc2xTVW51YldkU0VQcEZTNm85YkVuIiwib3JnYW5pemF0aW9uSWQiOjcyMDkxLCJ1c2VySWQiOjgzNjc4LCJmb3JFeHBpcmF0aW9uQ2hlY2siOiJmYTZiY2VmYi1mNTE0LTQ3MDItYTVmMy1mYzZlZTY1MGJmZmEifX0.VbvXICrHeVzvkuhOr-FZ-K7X8fUpCt9oSoaZ8kgYMuE\";");
    properties.setProperty("sasl.mechanism", "PLAIN");
    properties.setProperty("key.serializer", StringSerializer.class.getName());
    properties.setProperty("value.serializer", StringSerializer.class.getName());

    // create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
    // create the Producer record
    ProducerRecord<String, String> producerRecord =
        new ProducerRecord<>("demo_java", "hello world");
    // send data
producer.send(producerRecord);
    // tell the producer to send all data and block until done -- synchronous
    producer.flush();
    // flush and close the producer
  producer.close();
  }
}
