import java.util.Iterator;

public class StackLinkedList<E> implements StackInterface<E> { 
	class Node {  	
		E element; 
 		Node next; 
 	} 
		 
 	private Node stack = null; 
	 
 	@Override 
 	public void push(E element) {  	 	
        if (isEmpty()) {
            stack = new Node();
            stack.element = element;
            return;
        }
        Node newNode = new Node();
        newNode.element = element;
        topNode().next = newNode;
 	} 
 
 	@Override  	
	public E pop() { 
 	 	// Lấy một phần tử khỏi stack 
        if (isEmpty()) return null;
        if (stack.next == null) {
            E result = stack.element;
            stack = null;
            return result;
        }
        Node second = secondTopNode();
        Node result = second.next;
        second.next = null;
 	 	return result.element; 
    }

    private Node secondTopNode() {
        Node result = stack;
        while(result.next.next != null) {result = result.next;}
        return result;
    }

    private Node topNode () {
        if (isEmpty()) return null;
 	 	Node result = stack;
        while (result.next != null) {result = result.next;}
        return result;
    }
 
 	@Override 
 	public boolean isEmpty() { 
 	 		// Kiểm tra stack rỗng
 		return stack == null; 
 	} 

 	@Override 
 	public E top() { 
 	 	// Lấy giá trị phần tử đầu tiên của stack
        if (isEmpty()) return null;
        return topNode().element;
 	} 
 
 	@Override 
 	public Iterator<E> iterator() {  	 	
 	 	return new StackIterator(); 
 	} 

    class StackIterator implements Iterator<E> {  	
		private Node currentNode = stack; 

 	 	public boolean hasNext() { 
 	 		return currentNode != null; 
 	 	} 

		public E next() {  	 	 	
		    E data = currentNode.element;
            currentNode = currentNode.next;  	 	 	
		    return data; 
 	 	} 
 	} 
} 
