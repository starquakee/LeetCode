import java.util.Map;

public class num3719 {
    public int longestBalanced(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int left=0;left<n;left++){
            Map<Integer,Integer> odd = new java.util.HashMap<>();
            Map<Integer,Integer> even = new java.util.HashMap<>();
            if(nums[left]%2==0){
                even.put(nums[left],even.getOrDefault(nums[left],0)+1);
            }else{
                odd.put(nums[left],odd.getOrDefault(nums[left],0)+1);
            }
            for(int right=left+1;right<n;right++){
                if(nums[right]%2==0){
                    even.put(nums[right],even.getOrDefault(nums[right],0)+1);
                }else{
                    odd.put(nums[right],odd.getOrDefault(nums[right],0)+1);
                }
                if(even.size()==odd.size()){
                    ans=Math.max(ans,right-left+1);
                }
            }
        }
        return ans;
    }
}
