 

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCProblemManager {
    private Queue queue;
    Lock lock;
    Condition full;
    Condition empty;
    
    public PCProblemManager (Queue queue) {
        this.queue = queue;
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void produce() {
            lock.lock();    
            try {
                if(queue.isFull()) {    
                    System.out.println("Producer Waiting...");
                    if(full.await(1,TimeUnit.SECONDS))
                        System.out.println("Producer resumed");
                    else {
                        Thread.currentThread().interrupt();
                        throw new InterruptedException();
                    }
                }
                int random = new Random().nextInt(100);
                queue.add(random);
                System.out.println("Added " + random + 
                        "   Queue size: " + queue.size());
                empty.signal();
            } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " has shut down");
                } finally {
                    lock.unlock();
                }
 
    }

    public void consume() {
            lock.lock();
            try {
                if(queue.isEmpty()) {
                    System.out.println("Consumer Waiting...");
                    if(empty.await(1,TimeUnit.SECONDS)) 
                        System.out.println("Consumer Resumed");
                    else
                    {
                        Thread.currentThread().interrupt();
                        throw new InterruptedException();
                    }
                }
                int removed = queue.remove();
                System.out.println("Removed " + removed + 
                        "  Queue size: " + queue.size());
                full.signal();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has shut down");
            } finally {
                lock.unlock();
            }
    }
}
    

