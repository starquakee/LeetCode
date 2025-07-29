import java.util.Arrays;

public class num2411 {
    public int[] smallestSubarrays(int[] nums) {
        int[] ans=new int[nums.length];
        int[] pos=new int[31];
        Arrays.fill(pos,-1);
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<31;j++){
                if(((nums[i]>>j)&1)==1){
                    pos[j]=i;
                }else if(pos[j]!=-1){
                    ans[i]=Math.max(ans[i],pos[j]-i+1);
                }
            }
            if(ans[i]==0)ans[i]=1;
        }
        return ans;
    }
}
