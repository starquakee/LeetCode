public class num3487 {
    public int maxSum(int[] nums) {
        boolean[] visited = new boolean[101];
        int ans=0;
        int max=-1000;
        for(int num:nums){
            max=Math.max(max,num);
            if(num>0&&!visited[num]){
                visited[num]=true;
                ans+=num;
            }
        }
        if(ans==0){
            return max;
        }
        return ans;
    }
}
