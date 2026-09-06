import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadSafeLruCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;


    public ThreadSafeLruCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    @Override
    public synchronized V get(Object key) {
        return super.get(key);
    }

    @Override
    public synchronized V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public synchronized V remove(Object key) {
        return super.remove(key);
    }

    @Override
    protected synchronized boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }
}
