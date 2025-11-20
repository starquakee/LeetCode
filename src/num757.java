import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num757 {
    public int intersectionSizeTwo(int[][] intervals) {
        int m=2;
        int n=intervals.length;
        int ans=0;
        Arrays.sort(intervals,(a, b)-> {
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        List<Integer>[] lists=new List[n];
        for(int i=0;i<n;i++)lists[i]=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int k=lists[i].size();
            for(int j=intervals[i][0];k<m;j++){
                ans++;
                k++;
                add(lists,intervals,i,j);
            }
        }
        return ans;
    }
    public void add(List<Integer>[] lists,int[][] intervals,int i,int num){
        for(;i>=0;i--){
            if(intervals[i][1]>=num){
                lists[i].add(num);
            }else {
                break;
            }
        }
    }
}
