public class num2654 {
    public int minOperations(int[] nums) {
        int ans=nums.length;
        int[] temp=new int[nums.length];
        for (int num : nums) {
            if (num == 1) {
                ans--;
            }
        }
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for(int j=1;j<nums.length;j++){
            for(int i=0;i<nums.length-j;i++){
                temp[i]=gcd(temp[i],nums[i+j]);
                if(temp[i]==1)return ans+j-1;
            }
        }
        return -1;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
