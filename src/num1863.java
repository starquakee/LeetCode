import java.util.ArrayList;
import java.util.List;

public class num1863 {
    int ans=0;
//    public int subsetXORSum(int[] nums) {
//        dfs(nums,0,0);
//    }
//    void dfs(int[] nums,int value,int index){
//        if(index==nums.length){
//            ans+=value;
//            return;
//        }
//        dfs(nums,value,index+1);
//        dfs(nums,value^nums[index],index+1);
//    }
    public int subsetXORSum(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        backtrack(curr,0,nums);
        return ans;
    }
    public void backtrack(List<Integer> current,int index,int[] nums){
        if(index==nums.length){
            int res=0;
            for(int num:current){
                res^=num;
            }
            ans+=res;
            return;
        }
        backtrack(current,index+1,nums);
        current.add(nums[index]);
        backtrack(current,index+1,nums);
        current.remove(current.size()-1);
    }
}
