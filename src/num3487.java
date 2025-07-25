import java.util.Arrays;

public class num3487 {
    public int maxSum(int[] nums) {
        boolean[] visited = new boolean[101];
        int ans=0;
        for(int num:nums){
            if(num>0&&!visited[num]){
                visited[num]=true;
                ans+=num;
            }
        }
        if(ans==0){
            return Arrays.stream(nums).max().getAsInt();
        }
        return ans;
    }
}
