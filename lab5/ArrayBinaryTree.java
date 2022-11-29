public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
	private E [] array;
	private int n = 0;	
	private int defaultsize = 100;
	
	public ArrayBinaryTree(){
		array = (E[]) new Object[defaultsize]; 
 	}
	//update methods
 	public void setRoot(E element) {	
        if (n == 0) n++;
	 	array[1] = element;
 	}
 	public void setLeft(int p, E element) {
	 	// Set left child of p (at index 2p)
        if (array[2*p] == null) n++;
        array[2*p] = element;
	}
	public void setRight(int p, E element) {
	 	// Set right child of p (at index 2p+1)
        if (array[2*p] == null) n++;
        array[2*p + 1] = element;
  	}
    @Override
    public T root() {
        return (T)Integer.valueOf(1);
    }
    @Override
    public int size() {
        return n;
    }
    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    @Override
    public int numChildren(T p) {
        int result = 0;
        if (array[2 * (Integer)p] != null) result++;
        if (array[2 * (Integer)p + 1] != null) result++;
        return result;
    }
    @Override
    public T parent(T p) {
        return (T)Integer.valueOf((Integer)p/2);
    }
    @Override
    public T left(T p) {
        return (T)Integer.valueOf((Integer)p * 2);
    }
    @Override
    public T right(T p) {
        return (T)Integer.valueOf((Integer)p * 2 + 1);
    }
    @Override
    public T sibling(T p) {
        if ((Integer)p % 2 == 0) return (T)Integer.valueOf((Integer)p + 1);
        return (T)Integer.valueOf((Integer)p - 1);
    } 	
}
