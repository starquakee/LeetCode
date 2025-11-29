public class num3512 {
    public int minOperations(int[] nums, int k) {
        int ans=0;
        for(int num:nums)ans+=num;
        return ans%k;
    }
}
