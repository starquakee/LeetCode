import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {
    Map<Integer, Integer> fre;
    Map<Integer, Integer> map;
    public FrequencyTracker() {
        fre = new HashMap<>();
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
        if(map.get(number)>1){
            fre.put(map.get(number),fre.getOrDefault(map.get(number),0)+1);
            fre.put(map.get(number)-1,fre.get(map.get(number)-1)-1);
        }else if(map.get(number)==1){
            fre.put(1, fre.getOrDefault(1,0)+1);
        }
    }

    public void deleteOne(int number) {
        if(map.getOrDefault(number,0)>0){
            map.put(number, map.get(number)-1);
            fre.put(map.get(number),fre.getOrDefault(map.get(number),0)+1);
            fre.put(map.get(number)+1,fre.getOrDefault(map.get(number)+1,0)-1);
        }

    }

    public boolean hasFrequency(int frequency) {
        return fre.getOrDefault(frequency, 0)>0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */