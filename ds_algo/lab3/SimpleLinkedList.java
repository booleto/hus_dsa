public class SimpleLinkedList<T> { 
    class Node { 
        T data; 
        Node next; 
    }

    private Node top = null;  
    private Node bot = null;  
    private int n = 0;  

    private void updateTopBot() {
        if (n < 2) {
            return;
        }
        Node temp = top;
        while (temp.next != null) {
            temp = temp.next;
        }
        bot = temp;
    }

    public void add(T data) { 
        Node temp = top;
        top = new Node();
        top.data = data;
        top.next = temp;
        n++;
        updateTopBot();
    } 

    public void addBot(T data) { 
        bot.next = new Node();
        bot.next.data = data;
        bot = bot.next;
        n++;
    } 

    public T get(int i) { 
        if (i > n) {
            return null;
        }
        return getNode(i).data;
    } 

    Node getNode (int i) {
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node;
    }

    public void set(int i, T data){ 
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        updateTopBot();   
    } 

    public boolean isContain(T data) { 
        if (isEmpty()) {
            return false;
        }
        if (bot.data == data) {
            return true;
        }
        Node temp = top;
        while (temp.next != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    public int size() { 
        int result = 0;
        if (isEmpty()) {
            return result;
        }

        result++;
        Node temp = top;
        while (temp.next != null) {
            result++;
            temp = temp.next;
        }
        return result;
    } 

    public boolean isEmpty() { 
        if (top == null) {
            return true;
        }
        return false;
    } 

    public T removeTop() { 
        top = top.next;
        n--;
        return top.data;
    } 

    public T removeBot() {
        Node temp = top;
        while (temp.next != null) {
            temp = temp.next;
        }
        n--;
        bot = temp;
        T result = temp.next.data;
        bot.next = null;
        return result;
    }

    private void removeNode(int i) {
        getNode(i - 1).next = getNode(i + 1);
        n--;
    }

    public void remove(T data) { 
        Node temp = top;
        for (int i = 0; i < n; i++) {
            if (temp.data.equals(data)) {
                removeNode(i);
                n--;
            }
        }
    } 
}
