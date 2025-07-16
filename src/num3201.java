import java.util.ArrayList;
import java.util.List;

public class num3201 {
    public int maximumLength(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even.add(i);
            }else odd.add(i);
        }
        int ans=Math.max(even.size(),odd.size());
        int temp=1;
        //奇偶奇
        int l=0,r=0;
        while (l<odd.size()&&r<even.size()){
            while (r<even.size()&&odd.get(l)>even.get(r)){
                r++;
            }
            if(r>=even.size())break;
            temp++;
            while (l<odd.size()&&odd.get(l)<even.get(r)){
                l++;
            }
            if(l>=odd.size())break;
            temp++;
        }
        ans=Math.max(ans,temp);
        temp=1;
        //偶奇偶
        l=0;
        r=0;
        while (l<odd.size()&&r<even.size()){
            while (l<odd.size()&&odd.get(l)<even.get(r)){
                l++;
            }
            if(l>=odd.size())break;
            temp++;
            while (r<even.size()&&odd.get(l)>even.get(r)){
                r++;
            }
            if(r>=even.size())break;
            temp++;
        }
        ans=Math.max(ans,temp);
        return ans;
    }
}
