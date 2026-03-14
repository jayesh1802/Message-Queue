package com.jayesh.mq.consumer;

import com.jayesh.mq.broker.Broker;
import com.jayesh.mq.model.Message;

public class Consumer {

    private Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    public Message poll(String topic) {
        return broker.pollMessage(topic);
    }
}
