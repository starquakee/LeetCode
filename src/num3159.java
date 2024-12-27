import java.util.Arrays;

public class num3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] arr = new int[nums.length];
        int[] ans = new int[queries.length];
        Arrays.fill(arr,-1);
        Arrays.fill(ans,-1);
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x)arr[index++]=i;
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i]<=nums.length)ans[i]=arr[queries[i]-1];
        }
        return ans;
    }
}
