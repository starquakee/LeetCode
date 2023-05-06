import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
//        int right = nums.length-1;
//        int left = 0;
//        while (left+1<right){
//            for(int i=left+1;i<right;i++){
//                if(nums[left]>0){
//                    left = 0;
//                    right--;
//                }
//                if(nums[left]+nums[i]+nums[right]==0){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[left]);
//                    temp.add(nums[i]);
//                    temp.add(nums[right]);
//                    ans.add(temp);
//                }
//            }
//            left++;
//        }
        for(int i1=0;i1<nums.length;i1++){
            if(i1>0&&nums[i1]==nums[i1-1]) continue;
            int i3 = nums.length-1;
            for(int i2=i1+1;i2<nums.length;i2++){
                if(i2>i1+1&&nums[i2]==nums[i2-1]) continue;


//                    System.out.println(nums[i1]+" "+nums[i2]+" "+nums[i3]);
                while (i2<i3&&nums[i1]+nums[i2]+nums[i3]>0){
                    i3--;
                }
                if(i2==i3) break;
                if(nums[i1]+nums[i2]+nums[i3]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i1]);
                    temp.add(nums[i2]);
                    temp.add(nums[i3]);
                    ans.add(temp);
//                    break;
                }

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));

    }
}
