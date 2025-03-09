import java.util.Arrays;
import java.util.Comparator;

public class num2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (o1, o2) -> o1[0]-o2[0]);
        int n=items.length;
        for(int i=1;i<n;i++){
            items[i][1] = Math.max(items[i][1],items[i-1][1]);
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = query(queries[i],items);
        }
        return ans;
    }
    public int query(int money,int[][] items){
        int l=0,r=items.length-1;
        int mid;
        int ans=0;
        while (l<=r){
            mid=(l+r)/2;
            if(items[mid][0]<=money){
                ans=Math.max(ans,items[mid][1]);
                l=mid+1;
            }else if(items[mid][0]>money){
                r=mid-1;
            }
        }
        return ans;
    }
}
