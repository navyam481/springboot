package com.example.kafka;


import org.apache.kafka.common.serialization.Serdes;

public class MessageSerde extends Serdes.WrapperSerde<Message> {
    public MessageSerde() {
        super(new MessageSerializer(), new MessageDeserializer());
    }
}

