public class num453 {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums)min=Math.min(num,min);
        int ans=0;
        for(int num:nums)ans+=num-min;
        return ans;
    }
}
