public class num2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] min = new int[n];

        System.arraycopy(nums, 0, min, 0, n);
        long ans = getSum(nums);
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                min[j] = Math.min(min[j],nums[(j+i)%n]);
            }
            ans = Math.min(ans, (long) i *x+getSum(nums));
        }
        for(int i=0;i<n;i++){
            ans += min[i];
        }
        return ans;
    }
    public long getSum(int[] f) {
        long sum = 0;
        for (int num : f) {
            sum += num;
        }
        return sum;
    }
}
