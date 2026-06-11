import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num3558 {
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int max=dfs(list,1,0);
        int ans=1;
        for(int i=0;i<max-1;i++) {
            ans=(int)((long)(ans<<1)%1000000007);
        }
        return ans;
    }
    public int dfs(List<List<Integer>> list,int node,int parent){
        int max=0;
        for(int next:list.get(node)){
            if(next==parent) continue;
            max=Math.max(max, dfs(list,next,node)+1);
        }
        return max;
    }
}
