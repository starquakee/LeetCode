import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num3373 {
    Set<Integer> set = new HashSet<>();
    int num=0;
    int num2=0;
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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
        count2[0]=dfs(-1,0,children2,false,true,true);
        int maxCount2=Math.max(n+1-count2[0],count2[0]);
//        for(int i=1;i<n+1;i++){
//            count2[i]=dfs(-1,i,children2,false,true,true);
//            if(count2[i]!=count2[i-1]){
//                maxCount2=Math.max(count2[i],count2[i-1]);
//                break;
//            }
//        }

//        for(int c2:count2)maxCount2=Math.max(maxCount2,c2);
//        System.out.println(maxCount2);
        int[] ans=new int[m+1];
//        set.clear();
        for(int i=0;i<m+1;i++){
            if(set.isEmpty()){
                ans[i]=maxCount2+dfs(-1,i,children1,true,true,false);
                num=ans[i];
                System.out.println(num);
            }else {
                if(set.contains(i))ans[i]=num;
                else {
                    if(num2==0){
                        ans[i]=maxCount2+dfs(-1,i,children1,true,true,true);
                        num2=ans[i];
                    }else ans[i]=num2;
                }
            }

        }
        return ans;
    }
    private int dfs(int parent, int node, List<List<Integer>> children, boolean isEven,boolean isRoot,boolean isSecond){
        if(children.get(node).size()==1&&!isRoot){
            if(isEven){
                if(!isSecond)set.add(node);
                return 1;
            }
            else return 0;
        }
        int ans=0;
        if(isEven){
            if(!isSecond) set.add(node);
            ans++;
        }
        for(int child:children.get(node)){
            if(child!=parent){
                ans+=dfs(node,child,children,!isEven,false,isSecond);
            }
        }
        return ans;
    }
}
