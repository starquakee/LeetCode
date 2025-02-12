import java.util.Arrays;

public class num1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1,r=Arrays.stream(nums).max().getAsInt();
        int ans=r;
        while (l<=r){
            int cost=(l+r)/2;
            if(check(nums,maxOperations,cost)){
                r=cost-1;
                ans=Math.min(ans,cost);
            }else l=cost+1;
        }
        return ans;
    }
    public boolean check(int[] nums, int maxOperations, int cost){
        int needOperations=0;
        for(int num:nums){
            needOperations+=(num-1)/cost;
        }
        return needOperations<=maxOperations;
    }
}
