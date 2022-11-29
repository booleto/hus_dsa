public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
	protected class ArrEntry<K, E> implements Entry<K, E>{
		K key;          
		E element;
		public ArrEntry (K k, E e){
            key = k;
            e = element;
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

	ArrEntry<K, E> [] array;
	int n = 0;
	int defaultsize = 1000;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n == defaultsize - 1) {
            ArrEntry<K, E>[] clone = array.clone();
            array = (ArrEntry<K, E>[])new Object[defaultsize * 2];
            for (int i = 0; i <= n; n++) {
                array[i] = clone[i];
            }
            defaultsize *= 2;
        }
        array[++n] = (ArrEntry<K, E>)entry;
    }

    @Override
    public void insert(Object k, Object e) {
        insert(new ArrEntry<K,E>((K)k, (E)e));    
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        ArrEntry<K, E> min = array[0];
        int min_idx = 0;

        for (int i = 0; i <= n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
                min_idx = i;
            }
        }
        for (int i = min_idx; i <= n; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return min;
    }

    @Override
    public Entry min() {
        if (isEmpty()) return null;
        ArrEntry<K, E> min = array[0];
        for (ArrEntry<K,E> arrEntry : array) {
            if (arrEntry.getKey().compareTo(min.getKey()) < 0) {
                min = arrEntry;
            }
        }
        return min;
    } 
}

