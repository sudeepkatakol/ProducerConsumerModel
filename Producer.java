 

public class Producer
{
    private PCProblemManager manager;
    public Producer(PCProblemManager manager)
    {
        this.manager = manager;
    }

    public void produce()
    {
        manager.produce();
    }
}
