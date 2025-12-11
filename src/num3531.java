import java.util.*;

public class num3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans=0;
        Map<Integer, List<Integer>> mapX = new HashMap<>();
        Map<Integer, List<Integer>> mapY = new HashMap<>();
        for(int[] building:buildings){
            mapX.computeIfAbsent(building[0],key->new ArrayList<>());
            mapX.get(building[0]).add(building[1]);
            mapY.computeIfAbsent(building[1],key->new ArrayList<>());
            mapY.get(building[1]).add(building[0]);
        }
        for(Integer key:mapX.keySet()){
            List<Integer> list = mapX.get(key);
            Collections.sort(list);
        }
        for(Integer key:mapY.keySet()){
            List<Integer> list = mapY.get(key);
            Collections.sort(list);
        }
        for(Integer key:mapX.keySet()){
            List<Integer> list = mapX.get(key);
            if(list.size()>=3){
                for(int i=1;i<list.size()-1;i++){
                    int y=list.get(i);
                    List<Integer> yList = mapY.get(y);
                    if(key>yList.get(0)&&key<yList.get(yList.size()-1)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
