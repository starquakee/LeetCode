public class num3653 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int MOD=1000000007;
        for(int i=0;i<q;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];
            int idx=l;
            while(idx<=r){
                long temp= (long) nums[idx] *v;
                nums[idx]= (int) (temp%MOD);
                idx+=k;
            }
        }
        int ans=0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
