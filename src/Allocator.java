import java.util.*;

public class Allocator {
    private Map<Integer, Set<Integer>> map;
    private int[] arr;
    private int mostLeftIndex;
    public Allocator(int n) {
        arr = new int[n];
        map = new HashMap<>();
        Arrays.fill(arr,-1);
        mostLeftIndex=0;
    }

    public int allocate(int size, int mID) {
        map.putIfAbsent(mID,new HashSet<>());
        int index=mostLeftIndex;
        int ans=-1;
        boolean canFull=false;
        for(int i=index;i<arr.length;i++){
            int cnt=0;
            while (i<arr.length&&arr[i]==-1){
                cnt++;
                i++;
                if(cnt==size){
                    canFull=true;
                    for(int j=0;j<cnt;j++){
                        arr[i-j-1]=mID;
                        Set<Integer> set = map.get(mID);
                        set.add(i-j-1);
                    }
                    ans=i-cnt;
                    break;
                }
            }
            if(canFull){
                for(int k=0;k<arr.length;k++){
                    if(arr[k]==-1){
                        mostLeftIndex=k;
                        break;
                    }
                }
                break;
            }
        }
        return ans;
    }

    public int freeMemory(int mID) {
        Set<Integer> set=map.getOrDefault(mID,new HashSet<>());
        for(int num:set){
            arr[num]=-1;
        }
        for(int k=0;k<arr.length;k++){
            if(arr[k]==-1){
                mostLeftIndex=k;
                break;
            }
        }
        map.remove(mID);
        return set.size();
    }
}
