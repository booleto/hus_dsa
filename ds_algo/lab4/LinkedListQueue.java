import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    public class Node {
        E element;
        Node next;
    }

    Node top = null;

    private Node botNode() {
        if (top == null) return null;
        Node result = top;
        while (result.next != null) {
            result = result.next;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {
            Node curr_node = top;

            @Override
            public boolean hasNext() {
                return curr_node.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) return null;
                E result = curr_node.element;
                curr_node = curr_node.next;
                return result;
            }
            
        };
        return iter;
    }

    @Override
    public void enqueue(E element) {
        if (isEmpty()) {
            Node node = new Node();
            node.element = element;
            top = node;
        }
        Node bot = botNode();
        bot.next = new Node();
        bot.next.element = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        top = top.next;
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
