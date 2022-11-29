public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E>{
    protected class NodeEntry<K, E> implements Entry<K, E>{
		private K key;
		private E element;
		private NodeEntry<K, E> next;
		public NodeEntry (K k, E e) {
            key = k;
            element = e;
		}
        @Override
        public K getKey() {
            return key;
        }
        @Override
        public E getValue() {
            return element;
        }
	}

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (isEmpty()) {
            head = (NodeEntry<K, E>)entry;
            n++;
            return;
        }
        if (entry.getKey().compareTo(head.key) > 0) {
            NodeEntry<K, E> temp = head;
            head = (NodeEntry<K, E>)entry;
            head.next = temp;
            if (tail == null) {
                tail = temp;
            }
            return;
        }

        NodeEntry<K, E> temp = head.next;
        while (temp.next != null) {
            if (entry.getKey().compareTo(temp.key) > 0) {
                
            }
        }
        if (entry.getKey().compareTo(head.key) > 0) {
            temp = head;
            head = (NodeEntry<K, E>)entry;
            head.next = temp;
            if (tail == null) {
                tail = temp;
            }
            return;
        }
        if (entry.getKey().compareTo(tail.key) < 0) {
            
        }
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<K, E>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        NodeEntry<K, E> cursor = head;
        while (!cursor.next.equals(tail)) {
            cursor = cursor.next;
        }
        NodeEntry<K, E> temp = tail;
        tail = cursor;
        return temp;
    }

    @Override
    public Entry<K, E> min() {
        return tail;
    }
    
}
