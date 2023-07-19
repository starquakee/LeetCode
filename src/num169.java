public class num169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int num:nums){
            if(count==0) ans = num;
            if(num == ans){
                count++;
            }else {
                count--;
            }
        }
        return ans;
    }
}
