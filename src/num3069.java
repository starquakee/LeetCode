import java.util.ArrayList;
import java.util.List;

public class num3069 {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
            }else arr2.add(nums[i]);
        }
        int[] ans = new int[nums.length];

        for(int j=0;j<arr1.size();j++){
            ans[j]=arr1.get(j);
        }
        for(int j=0;j<arr2.size();j++){
            ans[j+arr1.size()]=arr2.get(j);
        }
        return ans;
    }
}
