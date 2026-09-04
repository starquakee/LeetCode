public class num3903 {
    public int firstStableIndex(int[] nums, int k) {
        int[] preMax=new int[nums.length];
        int[] postMin=new int[nums.length];
        preMax[0]=nums[0];
        postMin[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            preMax[i]=Math.max(preMax[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            postMin[i]=Math.min(postMin[i+1],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(preMax[i]-postMin[i]<=k)return i;
        }
        return -1;
    }
}
