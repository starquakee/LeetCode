import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class num3372 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m=edges1.length;
        int n=edges2.length;
        int[] count2=new int[n+1];
        List<List<Integer>> children1=new ArrayList<>();
        List<List<Integer>> children2=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            children2.add(new ArrayList<>());
        }
        for(int[] edge2:edges2){
            children2.get(edge2[0]).add(edge2[1]);
            children2.get(edge2[1]).add(edge2[0]);
        }
        for(int i=0;i<m+1;i++){
            children1.add(new ArrayList<>());
        }
        for(int[] edge1:edges1){
            children1.get(edge1[0]).add(edge1[1]);
            children1.get(edge1[1]).add(edge1[0]);
        }
        for(int i=0;i<n+1;i++){
            count2[i]=dfs(-1,i,children2,k-1);
        }
        int maxCount2=0;
        for(int c2:count2)maxCount2=Math.max(maxCount2,c2);
        int[] ans=new int[m+1];
        for(int i=0;i<m+1;i++){
            ans[i]=maxCount2+dfs(-1,i,children1,k);
        }
        return ans;
    }
    private int dfs(int parent, int node, List<List<Integer>> children, int k){
        if(k<0)return 0;
        int ans=1;
        for(int child:children.get(node)){
            if(child!=parent){
                ans+=dfs(node,child,children,k-1);
            }
        }
        return ans;
    }
}
