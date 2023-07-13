public class num45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int place = 0;
        while (place<n-1){
            int max_len = 0;
            int next_place = 0;
            for(int j=1;j<=nums[place];j++){
                if(place+j>=n-1) return ans+1;
                if(nums[place+j]+place+j>max_len){
                    max_len = nums[place+j]+place+j;
                    next_place = place+j;
                }
            }
            ans++;
            place = next_place;
        }
        return ans;
    }
}
