public class num2275 {
    public int maxOnes(int[] candidates, int k){
        int ans = 0;
        for(int num:candidates){
            if((num&(1<<k))!=0){
                ans++;
            }
        }
        return ans;
    }
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for(int i=0;i<25;i++){
            ans = Math.max(ans,maxOnes(candidates,i));
        }
        return ans;
    }
}
