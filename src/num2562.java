public class num2562 {
    public long findTheArrayConcVal(int[] nums) {
        int size = nums.length;
        int left = 0;
        int right = size-1;
        long ans = 0L;
        while (left<right){
            int x = nums[left];
            int y = nums[right];
            int length = String.valueOf(y).length();
            long newNum = (long) (Math.pow(10,length)*x+y);
            ans += newNum;
            left++;
            right--;
        }
        if(left==right)ans+=nums[left];
        return ans;
    }
}
