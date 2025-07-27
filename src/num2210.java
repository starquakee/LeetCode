public class num2210 {
    public int countHillValley(int[] nums) {
        boolean[] isHill = new boolean[nums.length];
        int ans = 0;
        for(int i=1;i<nums.length-1;i++){
            int l=i-1,r=i+1;
            while (l>=0&&nums[i]==nums[l]){
                l--;
            }
            if(l<0)continue;
            while (r<nums.length&&nums[r]==nums[i]){
                r++;
            }
            if(r==nums.length)continue;
            if(isHill[i-1]&&nums[i-1]==nums[i]){
                isHill[i]=true;
                continue;
            }
            if((nums[i]>nums[l]&&nums[i]>nums[r])||(nums[i]<nums[l]&&nums[i]<nums[r])){
                isHill[i] = true;
                ans++;
            }
        }
        return ans;
    }
}
