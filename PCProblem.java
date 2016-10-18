 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PCProblem {
    private final int NO_OF_PRODUCERS = 7;
    private final int NO_OF_CONSUMERS = 5;
    
    public void startProblem() {
        Queue queue = new Queue();
        PCProblemManager manager = new PCProblemManager(queue);
        Producer[] producer = new Producer[NO_OF_PRODUCERS];
        Consumer[] consumer = new Consumer[NO_OF_CONSUMERS];
        Thread[] producerThreads = new ProducerThread[NO_OF_PRODUCERS];
        Thread[] consumerThreads = new ConsumerThread[NO_OF_CONSUMERS];
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i=0; i<NO_OF_PRODUCERS; i++) {
            producer[i] = new Producer(manager);
            producerThreads[i] = new ProducerThread(producer[i], i);
            executor.submit(producerThreads[i]);
        }
        for(int i=0; i<NO_OF_CONSUMERS; i++) {
            consumer[i] = new Consumer(manager);
            consumerThreads[i] = new ConsumerThread(consumer[i], i);
            executor.submit(consumerThreads[i]);
        }
        executor.shutdown();
    }
    
    public static void main(String[] args) {
        new PCProblem().startProblem();
    }
    
}
