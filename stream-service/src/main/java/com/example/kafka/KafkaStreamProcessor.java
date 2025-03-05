package com.example.kafka;


import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaStreamProcessor {

    private static final String INPUT_TOPIC = "topic_kafka";
    private static final String OUTPUT_TOPIC = "processed-topic";
    private KafkaStreams streams;

    public KafkaStreamProcessor() {
        // Configuration setup
    }

    public void processStream() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ksql-stream-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, MessageSerde.class.getName());

        StreamsBuilder builder = new StreamsBuilder();
        setupStream(builder);

        streams = new KafkaStreams(builder.build(), props);
        streams.start();

        // Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
    }

    private void setupStream(StreamsBuilder builder) {
        MessageSerde messageSerde = new MessageSerde();

        KStream<String, Message> stream = builder.stream(INPUT_TOPIC, 
            org.apache.kafka.streams.kstream.Consumed.with(Serdes.String(), messageSerde));

        stream.mapValues(value -> new Message("Processed: " + value.getMessage(), value.getAuthor()))
              .to(OUTPUT_TOPIC, Produced.with(Serdes.String(), messageSerde));
    }

    private void shutdown() {
        if (streams != null) {
            streams.close();
        }
    }
}
