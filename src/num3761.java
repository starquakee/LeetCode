import java.util.Map;

public class num3761 {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map = new java.util.HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int rev=reverse(nums[i]);
            if(map.containsKey(nums[i])) {
                ans=Math.min(ans, i-map.get(nums[i]));
            }
            map.put(rev,i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int reverse(int num){
        int ans=0;
        while(num>0){
            ans=ans*10+num%10;
            num/=10;
        }
        return ans;
    }
}
