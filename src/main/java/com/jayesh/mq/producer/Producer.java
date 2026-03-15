package com.jayesh.mq.producer;

import com.jayesh.mq.broker.Broker;
import com.jayesh.mq.model.Message;

public class Producer {
    private Broker broker;
    public Producer(Broker broker){
        this.broker=broker;
    }
    public void send (String topic, String payload){
        broker.sendMessage(topic,new Message(payload));
    }

}
