public class num922 {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int oddIndex=1;
        int evenIndex=0;
        for(int num:nums){
            if(num%2==0){
                ans[evenIndex]=num;
                evenIndex+=2;
            }else {
                ans[oddIndex]=num;
                oddIndex+=2;
            }
        }
        return ans;
    }
}
