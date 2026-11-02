public class num3736 {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums)max=Math.max(num,max);
        int ans=0;
        for(int num:nums)ans+=max-num;
        return ans;
    }
}
