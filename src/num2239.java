public class num2239 {
    public int findClosestNumber(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int ansValue=ans;
        for(int num:nums){
            if(Math.abs(num)<=ansValue){
                if(Math.abs(num)==ansValue){
                    ans=Math.max(num, ans);
                }else {
                    ans=num;
                    ansValue=Math.abs(ans);
                }
            }
        }
        return ans;
    }
}
