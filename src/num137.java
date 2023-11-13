public class num137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int cnt = 0;
            for (int num : nums) {
                cnt += num>>i&1;
            }
            if(cnt%3!=0)ans += 1<<i;
        }
        return ans;
    }
}
