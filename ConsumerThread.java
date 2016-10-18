 

public class ConsumerThread extends Thread{
    private final int CONSUMTION_TIME = 5;
    private final int NO_OF_CONSUMPTIONS_PER_CONSUMER = 10;
    private Consumer consumer;
    public ConsumerThread (Consumer consumer, int id) {
        super(new Integer(id + 1).toString());
        this.consumer = consumer;
    }
    
    public void run() {
        try{
            for(int i=0; i<NO_OF_CONSUMPTIONS_PER_CONSUMER; i++) {
                Thread.sleep(CONSUMTION_TIME);
                consumer.consume();
            }
        } catch(InterruptedException e) {
            System.out.println("Consumer" + getName() + " Interrupted!");
        } 
    }
}
