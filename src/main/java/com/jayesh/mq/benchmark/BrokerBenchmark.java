package com.jayesh.mq.benchmark;

import com.jayesh.mq.broker.Broker;
import com.jayesh.mq.model.Message;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public class BrokerBenchmark {

    private Broker broker;
    private String topic = "orders";
    private int counter = 0;

    @Setup(Level.Trial)
    public void setup() {
        broker = new Broker();

        for (int i = 0; i < 100000; i++) {
            broker.sendMessage(topic, new Message("msg-" + i));
        }
    }

    @Benchmark
    public void produce() {
        broker.sendMessage(topic, new Message("msg-" + counter++));

        if (counter > 100000) {
            broker.pollMessage(topic);
        }
    }

    @Benchmark
    public void consume(org.openjdk.jmh.infra.Blackhole bh) {
        Message msg = broker.pollMessage(topic);
        bh.consume(msg);
    }
}
