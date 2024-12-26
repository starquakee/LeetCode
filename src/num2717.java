public class num2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==1)left= i;
            if(nums[i]==n)right = n-i-1;
        }
        if(left+right<=n-2){
            return left+right;
        }else {
            return left+right-1;
        }
    }
}
