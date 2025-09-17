import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberContainers {
    public Map<Integer, PriorityQueue<Integer>> map;
    public Map<Integer,Integer> indexMap;
    public NumberContainers() {
        map = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        indexMap.put(index, number);
        if(!map.containsKey(number)){
            map.put(number, new PriorityQueue<>());
        }
        map.get(number).add(index);
    }

    public int find(int number) {
        if(map.containsKey(number)&&!map.get(number).isEmpty()) {
            int index = map.get(number).peek();
            while (indexMap.get(index) != number) {
                map.get(number).poll();
                if(map.get(number).isEmpty())break;
                index = map.get(number).peek();
            }
            if(!map.get(number).isEmpty()) {
                return index;
            }
        }
        return -1;
    }
}
