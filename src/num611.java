import java.util.Arrays;

public class num611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int l=j+1;
                int r=n-1;
                int mid=l+(r-l)/2;
                int num=0;
                while(l<=r){
                    mid=l+(r-l)/2;
                    if(nums[mid]<nums[i]+nums[j]){
                        num=Math.max(num,mid-j);
                        l=mid+1;
                    }else {
                        r=mid-1;
                    }
                }
                ans+=num;
            }
        }
        return ans;
    }
}
