package com.jayesh.mq.broker;

import com.jayesh.mq.model.Message;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    private Map<String,TopicQueue> topics= new HashMap<>();
    private TopicQueue getOrCreateTopic(String topic){
        return topics.computeIfAbsent(topic,t->new TopicQueue());
    }
    public void sendMessage(String topic, Message message){
        getOrCreateTopic(topic).enqueue(message);
    }
    public Message pollMessage(String topic){
        TopicQueue queue = topics.get(topic);
        if (queue == null) return null;
        return queue.dequeue();
    }


}
