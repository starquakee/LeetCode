public class num41_ {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(nums[i]>0&&nums[i]<=n){
                a[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(a[i]==0){
                return i;
            }
        }
        return n+1;
    }
}
