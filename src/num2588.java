import java.util.Arrays;

public class num2588 {
    public long beautifulSubarrays(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]^nums[i];
        }
        Arrays.sort(prefix);
        long ans=0L;
        for(int i=1;i<n;i++){
            long count=1L;
            while (i<n&&prefix[i]==prefix[i-1]){
                count++;
                i++;
            }
            ans+=(count*count-count)/2;
        }
        for(int pre:prefix){
            if(pre==0)ans++;
        }
        return ans;
    }
}
