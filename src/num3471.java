public class num3471 {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int[] isVisit=new int[51];
        for(int i=0;i<n;i++){
            isVisit[nums[i]]++;
        }
        if(k==1){
            for(int i=50;i>=0;i--){
                if(isVisit[i]==1)return i;
            }
            return -1;
        }
        if(k==n){
            for(int i=50;i>=0;i--){
                if(isVisit[i]>0)return i;
            }
            return -1;
        }
        boolean first=false;
        boolean last=false;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]==nums[0])first=true;
            if(nums[i]==nums[nums.length-1])last=true;
        }

        if(first&last)return -1;
        if(first)return nums[nums.length-1];
        if(last)return nums[0];
        if(nums[0]==nums[n-1])return -1;
        return Math.max(nums[0],nums[nums.length-1]);
    }
}
