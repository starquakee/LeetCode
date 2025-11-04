import java.util.*;

public class num3318 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(list,(a,b)->{
            if(a[1]!=b[1])return b[1]-a[1];
            return b[0]-a[0];
        });
        for(int i=0;i<x&&i<list.size();i++)ans[0]+=list.get(i)[0]*list.get(i)[1];
        for(int i=1;i<n-k+1;i++){
            map.put(nums[i-1],map.getOrDefault(nums[i-1],0)-1);
            map.put(nums[i+k-1],map.getOrDefault(nums[i+k-1],0)+1);
            list.clear();
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(list,(a,b)->{
                if(a[1]!=b[1])return b[1]-a[1];
                return b[0]-a[0];
            });
            for(int j=0;j<x&&i<list.size();j++)ans[i]+=list.get(j)[0]*list.get(j)[1];
        }
        return ans;
    }
}
