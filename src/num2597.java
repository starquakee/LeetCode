import java.util.HashMap;
import java.util.Map;

public class num2597 {
    private int ans=0;
    private Map<Integer,Integer> map;
    public int beautifulSubsets(int[] nums, int k) {
        map = new HashMap<>();
        backward(nums,k,0);
        return ans-1;
    }
    public void backward(int[] nums,int k, int index){
        if(index==nums.length){
            ans++;
            return;
        }
        backward(nums,k,index+1);
        if(map.getOrDefault(nums[index]+k,0)==0&&map.getOrDefault(nums[index]-k,0)==0){
            map.put(nums[index], map.getOrDefault(nums[index],0)+1);
            backward(nums,k,index+1);
            map.put(nums[index], map.getOrDefault(nums[index],0)-1);
        }
    }
}
