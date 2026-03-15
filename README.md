# [High Performace Message Queue] 🚀
**A High-Performance Message Broker built from scratch in Java.**

It is a systems-engineering project designed to explore the internals of distributed message brokers like Apache Kafka. It focuses on high throughput, low latency, and efficient memory utilization.

## 📊 Current Progress: Phase 1 (In-Memory Baseline)
I have successfully implemented the core in-memory broker logic and established a scientific benchmarking suite using **JMH (Java Microbenchmark Harness)**.

### Performance Results (Baseline)
Measured on: **JDK 22** | **JMH 1.37** | **1 Thread**

| Operation | Throughput (ops/sec) | Description |
| :--- | :--- | :--- |
| **Produce** | **~15.5 Million** | `sendMessage()` + `Message` object allocation |
| **Consume** | **~30.8 Million** | `pollMessage()` from an active queue |

*These numbers represent the raw memory-speed baseline before adding networking, disk I/O, or multi-threaded contention.*

---

## 🏗️ Architecture Overview
The current implementation follows a decoupled Producer-Broker-Consumer model:
* **Broker:** Acts as the central registry, managing a `Map` of Topic-to-Queue relations.
* **Topic:** Logical namespaces for messages.
* **Message:** Data units containing payload and nanosecond-precision timestamps for latency tracking.
* **Storage:** Currently Utilizing Data Structure

---

## 🛠️ Tech Stack & Tools
* **Language:** Java 22 (leveraging modern JVM optimizations).
* **Build System:** Maven (Dependency management and lifecycle).
* **Benchmarking:** JMH (The OpenJDK standard for microbenchmarks to prevent JIT optimization errors).
* **Version Control:** Git.

---

## 🚦 How to Run
To run the benchmarks yourself:
1. Ensure you have **Maven** and **JDK 22+** installed.
2. Clone the repository and navigate to the root.
3. Build the project:
   ```bash
   mvn clean install
