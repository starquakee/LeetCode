public class num3095 {
    // sliding window
    public int minimumSubarrayLength(int[] nums, int k) {
        int left=0;
        int right=0;
        int[] bits = new int[30];
        int ans = Integer.MAX_VALUE;
        while (right<nums.length){
            for(int i=0;i<30;i++){
                bits[i] += (1<<i)&nums[right];
            }
            int num = bits2num(bits);
            while (num>=k&&left<nums.length&&right>=left){
                ans = Math.min(ans, right-left+1);
                for(int i=0;i<30;i++){
                    bits[i] -= (1<<i)&nums[left];
                }
                left++;
                num = bits2num(bits);
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int bits2num(int[] bits){
        int num=0;
        for(int i=0;i<bits.length;i++){
            if(bits[i]>0)num+= (int) Math.pow(2,i);
        }
        return num;
    }
}
