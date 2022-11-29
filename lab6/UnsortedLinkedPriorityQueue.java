public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface { 
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
	private NodeEntry<K,E> head;
	private NodeEntry<K,E> tail;
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
    public void insert(Entry entry) {
        if (isEmpty()) {
            head = (NodeEntry<K, E>)entry;
            n++;
            return;
        }
        if (n == 1) {
            tail = (NodeEntry<K, E>)entry;
            head.next = tail;
            n++;
            return;
        }
        tail.next = (NodeEntry<K, E>)entry;
        tail = tail.next;
        n++;
    }

    @Override
    public void insert(Object k, Object e) {
        insert(new NodeEntry<K,E>((K)k, (E)e));
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        if (tail == null) {
            NodeEntry<K, E> temp = head;
            head = null;
            return temp;
        }
        NodeEntry<K, E> cursor = head;
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> beforeMin = head;
        while (cursor.next != null) {
            if (min.key.compareTo(cursor.next.key) > 0) {
                min = cursor.next;
                beforeMin = cursor;
            }
        }
        beforeMin.next = min.next;
        return min;
    }

    @Override
    public Entry min() {
        if (isEmpty()) return null;
        if (tail == null) {
            NodeEntry<K, E> temp = head;
            head = null;
            return temp;
        }
        NodeEntry<K, E> cursor = head;
        NodeEntry<K, E> min = head;
        while (cursor.next != null) {
            if (min.key.compareTo(cursor.key) > 0) {
                min = cursor;
            }
        }
        return min;
    }    
}
