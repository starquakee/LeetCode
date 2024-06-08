import java.util.Arrays;
import java.util.Map;

public class num3040 {
    int[][] memo;
    int[] nums;
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if(n<2)return 0;
        memo = new int[n][n];
        this.nums = nums;
        int target1 = nums[0]+nums[1];
        int target2 = nums[n-2]+nums[n-1];
        int target3 = nums[0]+nums[n-1];
        int ans = 0;
        ans = Math.max(ans,helper(0,n-1,target1));
        ans = Math.max(ans,helper(0,n-1,target2));
        ans = Math.max(ans,helper(0,n-1,target3));
        return ans;
    }
    public int helper(int i,int j,int target){
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(i,j,target);
    }
    public int dfs(int i,int j,int target){
        int ans = 0;
        if(i>=j)return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        if(nums[i]+nums[i+1]==target){
            ans = Math.max(ans,dfs(i+2,j,target)+1);
        }
        if(nums[j]+nums[j-1]==target){
            ans = Math.max(ans,dfs(i,j-2,target)+1);
        }
        if(nums[i]+nums[j]==target){
            ans = Math.max(ans,dfs(i+1,j-1,target)+1);
        }
        memo[i][j] = ans;
        return ans;
    }
}
