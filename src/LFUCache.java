import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    static class node{
        int key;
        int value;
        node prev;
        node next;
        int cnt;
        public node() {}
        public node(int _key, int _value) {key = _key; value = _value;}
    }
    private final Map<Integer, node> map = new HashMap<>();
    private final int capacity;
    private int size;
    private final node head;
    private final node tail;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new node();
        this.tail = new node();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        node ans = map.get(key);
        if(ans == null){
            return -1;
        }else {
            move2head(ans);
            return ans.value;
        }
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node ans = map.get(key);
            ans.value = value;
            move2head(ans);
        }else {
            node node_new = new node(key, value);
            size++;
            map.put(key,node_new);
            add2head(node_new);
            if(size>capacity){
                size--;
                node last = removeLast();
                map.remove(last.key);
            }
        }
    }

    private void move2head(node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        add2head(node);
    }
    private void add2head(node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    private node removeLast(){
        node last = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return last;
    }
}
