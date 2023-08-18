import java.util.LinkedList;

public class CustomHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public CustomHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        for(int i=0;i<capacity;i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode()%buckets.length;
        LinkedList<Entry<K,V>> bucket = buckets[index];
        for(Entry<K,V> entry:bucket){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key,value));
    }

    public V get(K key) {
        int index = key.hashCode()% buckets.length;
        LinkedList<Entry<K,V>> bucket = buckets[index];
        for(Entry<K,V> entry:bucket){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }


    private static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
