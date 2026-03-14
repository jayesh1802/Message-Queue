package com.jayesh.mq.benchmark;

import com.jayesh.mq.broker.Broker;
import com.jayesh.mq.model.Message;

public class Benchmark {

    public static void run() {

        Broker broker = new Broker();

        int totalMessages = 1_000_000;
        String topic = "orders";

        long startTime = System.nanoTime();

        // PRODUCE
        for (int i = 0; i < totalMessages; i++) {
            broker.sendMessage(topic, new Message("msg-" + i));
        }

        // CONSUME
        int received = 0;

        while (received < totalMessages) {

            Message msg = broker.pollMessage(topic);

            if (msg != null) {
                received++;
            }
        }

        long endTime = System.nanoTime();

        double seconds = (endTime - startTime) / 1e9;
        double throughput = totalMessages / seconds;

        System.out.println("Messages: " + totalMessages);
        System.out.println("Time: " + seconds + " sec");
        System.out.println("Throughput: " + throughput + " msg/sec");
    }
}