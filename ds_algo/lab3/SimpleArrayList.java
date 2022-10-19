import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {  
	private T[] array;  
	private int n = 0; 
 	private int defaultSize = 100; 
 
 	public SimpleArrayList() { 
	  	array = (T[]) new Object[defaultSize]; 
 	} 
  	public SimpleArrayList(int capacity) {   	
		array = (T[]) new Object[capacity];
 	} 
 	public void add(T data) { 
 		if (n == array.length) {
            T[] temp = array;
            array = (T[]) new Object[defaultSize * 2];
            for (int i = 0; i < n; i++) {
                array[i] = temp[i];
            }
        }
        array[n] = data;
        n++;
    }
  	public T get(int i) {   		
		return array[i];
 	} 
	public void set(int i, T data) { 
 		array[i] = data;
	} 
 	public void remove(T data) { 
        int removed_idx = n;
 		for (int i = 0; i < n; i++) {
            if (array[i] == data) {
                removed_idx = i;
                break;
            }
        }
        for (int i = removed_idx; i < n; i++) {
            array[i] = array[i + 1];
        }
	} 
  	public boolean isContain(T data) { 
  		for (T t : array) {
            if (t.equals(data)) {
                return true;
            }
        }
        return false;
	} 
  	public int size() { 
	  	return n;
 	} 
  	public boolean isEmpty() {   		// Hoàn thành thân hàm
        return n == 0;
	} 
 	public Iterator<T> iterator() {  
        Iterator<T> it = new Iterator<T>() {
            private int curr_idx = 0;

            @Override
            public boolean hasNext() {
                return curr_idx < n;
            }

            @Override
            public T next() {
                return array[curr_idx++];
            }

            @Override
            public void remove() {
                Iterator.super.remove();
            }
        };
        return it;
 	} 
 } 
