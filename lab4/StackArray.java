import java.util.Iterator;

public class StackArray<E> implements StackInterface<E>{
    private static final int INIT_CAPACITY = 100;
    private E data[];
    private int t = -1;

    public StackArray() {
        this(INIT_CAPACITY);
    }

    public StackArray(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void push(E element) throws IllegalStateException{
        if (size() == data.length) {throw new IllegalStateException("Stack full roi tr oi");}
        data[++t] = element;
    }

    public int size() {
        return t + 1;
    }

    public E pop(){
        if(isEmpty()) return null;
        E result = data[t];
        data[t--] = null;
        return result;
    } 

    public boolean isEmpty(){
        return t == -1;
    } 

    public E top(){
        if (isEmpty()) return null;
        return data[t];
    }

    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {
            private int curr_idx = 0;

            @Override
            public boolean hasNext() {
                return curr_idx <= t;
            }

            @Override
            public E next() {
                if (!hasNext()) return null;
                return data[curr_idx++];
            }
        };
        return iter;
    }
}
