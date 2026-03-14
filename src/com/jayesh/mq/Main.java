package com.jayesh.mq;

import com.jayesh.mq.benchmark.Benchmark;
import com.jayesh.mq.broker.Broker;
import com.jayesh.mq.consumer.Consumer;
import com.jayesh.mq.producer.Producer;

public class Main {

    public static void main(String[] args) {
        Benchmark.run();
    }
}