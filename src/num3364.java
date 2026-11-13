import java.util.List;

public class num3364 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=l;i<=r;i++){
            int sum=0;
            for(int j=0;j<i;j++)sum+=nums.get(j);
            if(sum>0)ans=Math.min(ans,sum);
            for(int j=1;j+i-1<n;j++){
                sum-=nums.get(j-1);
                sum+=nums.get(i+j-1);
                if(sum>0)ans=Math.min(ans,sum);
            }
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}
