import java.util.Arrays;

public class num3634 {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=n;
        int right=0;
        for(int i=0;i<n;i++){
            for(int j=right;j<n;j++){
                long temp=(long)nums[i]*k;
                if(nums[j]>temp){
                    ans=Math.min(ans,n-(j - i));
                    right=j;
                    break;
                }
                if(j==n-1){
                    ans=Math.min(ans,n-(j - i + 1));
                    right=j;
                }
            }
        }
        return ans;
    }
}
