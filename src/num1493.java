import java.util.ArrayList;
import java.util.List;

public class num1493 {
    public int longestSubarray(int[] nums) {
        boolean containZero=false;
        int ans=0;
        int n=nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(nums[i]==0&&nums[i-1]==1&&nums[i+1]==1){
                list.add(i);
            }
        }
        int[] preOnes=new int[n];
        int[] postOnes=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                containZero=true;
            }
            if(i==0){
                preOnes[i]=nums[i];
                ans=Math.max(ans,preOnes[i]);
            }else if(nums[i]==1){
                preOnes[i]=preOnes[i-1]+1;
                ans=Math.max(ans,preOnes[i]);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                postOnes[i]=nums[i];
                ans=Math.max(ans,preOnes[i]);
            }else if(nums[i]==1){
                postOnes[i]=postOnes[i+1]+1;
                ans=Math.max(ans,postOnes[i]);
            }
        }
        if(list.isEmpty()){
            if(containZero){
                return ans;
            }else{
                return ans-1;
            }
        }
        for(int num:list){
            ans=Math.max(ans,preOnes[num-1]+postOnes[num+1]);
        }
        return ans;
    }
}
