public class num2216 {
    public int minDeletion(int[] nums) {
        int ans = 0;
        boolean isEven = true;
        for(int i=0;i<nums.length-1;i++){
            if(i%2==0&&isEven){
                if(nums[i]==nums[i+1]){
                    ans++;
                    isEven = false;
                }
            } else if(i%2==1&&!isEven){
                if(nums[i]==nums[i+1]){
                    ans++;
                    isEven = true;
                }
            }
        }
        if((nums.length-ans)%2==1)ans++;
        return ans;
    }
}
