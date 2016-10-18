 

public class ProducerThread extends Thread {
    private final int PRODUCTION_TIME = 20;
    private final int NO_OF_PRODUCTIONS_PER_PRODUCER = 10;
    private Producer producer;
    
    public ProducerThread (Producer producer, int id) {
        super(new Integer(id + 1).toString());
        this.producer = producer;
    }
    public void run() {
        try{
            for(int i=0; i<NO_OF_PRODUCTIONS_PER_PRODUCER; i++) {
                Thread.sleep(PRODUCTION_TIME);
                producer.produce();
            }
        } catch(InterruptedException e) {
            System.out.println("Producer" + getName() + " Interrupted!");
        } 
    }
}
