import java.util.ArrayList;
import java.util.List;

public class num2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long ans=0L;
        List<Integer> intervals = new ArrayList<>();
        intervals.add(-1);
        for(int i=0;i<n;i++){
            if(nums[i]>maxK||nums[i]<minK)intervals.add(i);
        }
        intervals.add(n);
        for(int i=0;i<intervals.size()-1;i++){
            int begin=intervals.get(i);
            int end=intervals.get(i+1);
            int minIndex=-1;
            int maxIndex=-1;
            for(int j=begin+1;j<end;j++){
                if(nums[j]==minK)minIndex=j;
                if(nums[j]==maxK)maxIndex=j;
                if(minIndex!=-1&&maxIndex!=-1){
                    ans+=Math.min(minIndex,maxIndex)-begin;
                }
            }
        }
        return ans;
    }
}
