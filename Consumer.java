 

public class Consumer
{
    private PCProblemManager manager;
    
    public Consumer(PCProblemManager manager)
    {
        this.manager = manager;
    }

    public void consume()
    {
        manager.consume();
    }
}