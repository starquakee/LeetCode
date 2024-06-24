public class num503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] temp = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i] = nums[i];
            temp[i+nums.length] = nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = -1;
            for(int j=i+1;j<temp.length;j++){
                if(temp[j]>temp[i]){
                    ans[i] = temp[j];
                    break;
                }
            }
        }
        return ans;
    }
}
