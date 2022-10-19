import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> { 	
	private E[] queue;  	
	private int n = 0;  	
	private int top = 0;  	
	private int count = 0;  	
	private int default_size = 100; 
 
 	public ArrayQueue(int capacity) { 
	 	n = capacity; 
	 	queue = (E[]) new Object[capacity]; 
	} 

	public ArrayQueue() { 
 	 	n = default_size; 
 		queue = (E[]) new Object[default_size]; 
	} 

  	@Override 
 	public void enqueue(E element) throws IllegalStateException {  	 	
		if (count == n) throw new IllegalStateException("queue het cho roi tr");
        int avail = (top + count) % n;
        queue[avail] = element;
        count++;
  	} 

  	@Override  	
	public E dequeue() { 
 	 	if (isEmpty()) return null;
        E result = queue[top];
        queue[top] = null;
        top = (top + 1) % count;
        return result;
 	} 

  	@Override 
 	public boolean isEmpty() { 
 	 	return count == 0; 
 	} 

 	@Override 
 	public Iterator<E> iterator() {  	 	
		// TODO Auto-generated method stub  	 	
		return new ArrayQueueIterator(); 
 	} 
 
 	class ArrayQueueIterator implements Iterator<E> { 
 	 	private int current = top;  	 	
		private int num = 0; 

 	 	@Override 
	 	public boolean hasNext() {  	 	 	  	 	 	
			return num < count; 
		} 

 		@Override  	 	
		public E next() { 
 	 		E data = queue[(current + num) % n];  	 	
			num++; 
	 		return data; 
		} 
	} 
 } 

