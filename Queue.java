 

public class Queue {
    private int[] queue;
    int size = 0;
    private final int MAX_SIZE = 10;
    
    public Queue() {
        queue = new int[MAX_SIZE];
    }
    
    public int size() {
        return size;
    }
    
    public void add(int i) {
        queue[size++] = i;
        
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean isFull() {
        return size() == MAX_SIZE;
    }
    
    public int remove() {
        int c = queue[--size];
        queue[size] = -1;
        return c;
    }
}
