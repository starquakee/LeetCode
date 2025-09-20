import java.util.*;

public class Router {
    List<int[]> list;
    int size;
    Set<String> checkRepeat;
    Map<String,List<Integer>> map;
    public Router(int memoryLimit) {
        list = new ArrayList<int[]>();
        size = memoryLimit;
        checkRepeat = new HashSet<String>();
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        if(checkRepeat.contains(source+"-"+destination+"-"+timestamp)) {
            return false;
        }
        if(list.size() >= size) {
            int[] remove = list.remove(0);
            checkRepeat.remove(remove[0]+"-"+remove[1]+"-"+remove[2]);
            List<Integer> times = map.get(String.valueOf(remove[1]));
            times.remove(0);
        }
        int[] temp = new int[]{source, destination, timestamp};
        checkRepeat.add(source+"-"+destination+"-"+timestamp);
        list.add(temp);
        if(!map.containsKey(String.valueOf(destination))) {
            map.put(String.valueOf(destination), new ArrayList<>());
        }
        map.get(String.valueOf(destination)).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if(list.isEmpty()) {return new int[0];}
        int[] remove = list.remove(0);
        checkRepeat.remove(remove[0]+"-"+remove[1]+"-"+remove[2]);
        map.get(String.valueOf(remove[1])).remove(0);
        return remove;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> l = map.getOrDefault(String.valueOf(destination), new ArrayList<>());
        int count = 0;
        for(int time : l) {
            if(time >= startTime && time <= endTime) {
                count++;
            }
        }
        return count;
    }
}
