import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num15 {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        for(int i1=0;i1<nums.length;i1++){
//            if(i1>0&&nums[i1]==nums[i1-1]) continue;
//            int i3 = nums.length-1;
//            for(int i2=i1+1;i2<nums.length;i2++){
//                if(i2>i1+1&&nums[i2]==nums[i2-1]) continue;
////                    System.out.println(nums[i1]+" "+nums[i2]+" "+nums[i3]);
//                while (i2<i3&&nums[i1]+nums[i2]+nums[i3]>0){
//                    i3--;
//                }
//                if(i2==i3) break;
//                if(nums[i1]+nums[i2]+nums[i3]==0){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i1]);
//                    temp.add(nums[i2]);
//                    temp.add(nums[i3]);
//                    ans.add(temp);
////                    break;
//                }
//            }
//        }
//        return ans;
//    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<>();
//        for(int i1=0;i1<=n-3;i1++){
//            if(i1>0&&nums[i1]==nums[i1-1]) continue;
//            int i3=n-1;
//            for(int i2=i1+1;i2<i3;i2++){
//                if(i2>i1+1&&nums[i2]==nums[i2-1]) continue;
//                while (nums[i1]+nums[i2]+nums[i3]>0&&i3>i2){
//                    i3--;
//                }
//                if(i3==i2) continue;
//                if(nums[i1]+nums[i2]+nums[i3]==0){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i1]);
//                    temp.add(nums[i2]);
//                    temp.add(nums[i3]);
//                    ans.add(temp);
//                }
//            }
//        }
//        return ans;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i1=0;i1<n-2;i1++){
            if(i1>0&&nums[i1]==nums[i1-1]) continue;
            int i2=i1+1,i3=n-1;
            while (i2<i3){
                if(i2>i1+1&&nums[i2]==nums[i2-1]){
                    i2++;
                    continue;
                }
                if(nums[i1]+nums[i2]+nums[i3]<0){
                    i2++;
                }else if(nums[i1]+nums[i2]+nums[i3]>0){
                    i3--;
                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i1]);
                    temp.add(nums[i2]);
                    temp.add(nums[i3]);
                    ans.add(temp);
                    i2++;
                }
            }
        }
        return ans;
    }
}
