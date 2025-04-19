import java.util.Arrays;

public class num2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        if(n==1)return 0L;
        long ans=((long) n*n-n)/2;
        Arrays.sort(nums);
        int right=n-1;
        for(int i=0;i<n-1;i++){
            while (right>i&&nums[i]+nums[right]>upper)right--;
            ans-=Math.min(n-right-1,n-i-1);
        }
        for(int i=0;i<n-1;i++){
            int l=i+1,r=n-1;
            int maxL=i;
            while (l<=r){
                int mid=(l+r)/2;
                if(nums[i]+nums[mid]>=lower){
                    r=mid-1;
                }else {
                    maxL=Math.max(mid,maxL);
                    l=mid+1;
                }
            }
            ans-=maxL-i;
        }
        return ans;
    }
}
