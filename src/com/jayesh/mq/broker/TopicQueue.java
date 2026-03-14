package com.jayesh.mq.broker;

import com.jayesh.mq.model.Message;

import java.util.LinkedList;
import java.util.Queue;

public class TopicQueue {
    private Queue<Message> queue= new LinkedList<>();
    public void enqueue(Message message){
        queue.add(message);
    }
    public Message dequeue(){
        if(!queue.isEmpty()){
            return queue.poll();
        }
        return new Message("Queue Empty");
    }
    public int size(){
        return queue.size();
    }



}
