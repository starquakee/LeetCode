public class num3300 {
    public int minElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int num:nums){
            int temp=0;
            while (num>0){
                temp+=num%10;
                num/=10;
            }
            ans=Math.min(ans,temp);
            if(ans==1){
                break;
            }
        }
        return ans;
    }
}
