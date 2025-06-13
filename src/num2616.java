import java.util.Arrays;

public class num2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];
        while (left<=right){
            int count=0;
            int mid=(left+right)/2;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]-nums[i]<=mid){
                    count++;
                    i++;
                }
            }
            if(count<p){
                left=mid+1;
            }else right=mid-1;
        }
        return left;
    }
}
