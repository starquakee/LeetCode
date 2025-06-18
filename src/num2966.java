import java.util.Arrays;

public class num2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] ans=new int[n/3][3];
        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                ans[i][j]=nums[3*i+j];
            }
            if(ans[i][2]-ans[i][0]>k)return new int[][]{};
        }
        return ans;
    }
}
