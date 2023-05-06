import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class TreeNodeChildren {
    int val;
    List<TreeNodeChildren> children = new ArrayList<>();
    TreeNodeChildren() {}
    TreeNodeChildren(int val) { this.val = val; }

}
public class num1376 {
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for(int i=0;i<n;i++){
//            map.putIfAbsent(manager[i], new ArrayList<Integer>());
//            map.get(manager[i]).add(i);
//
//        }
//        return dfs(headID, informTime, map);
//    }
//    public int dfs(int headID, int[] informTime, Map<Integer,List<Integer>> map){
//        int ans = 0;
//        for(int child:map.getOrDefault(headID, new ArrayList<>())){
//            ans = Math.max(ans, dfs(child, informTime,map));
//        }
//        return ans+informTime[headID];
//    }
public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    TreeNodeChildren[] arr = new TreeNodeChildren[n];
    for(int i=0;i<n;i++){
        arr[i] = new TreeNodeChildren(informTime[i]);
    }
    for(int i=0;i<n;i++){
        if(manager[i]!=-1){
            arr[manager[i]].children.add(arr[i]);
        }
    }
    return dfs(arr[headID]);
}
public int dfs(TreeNodeChildren root){
    int ans = 0;
    if(root==null)return 0;
    for(TreeNodeChildren child:root.children){
        ans = Math.max(ans, dfs(child));
    }
    return ans+ root.val;
}

    public static void main(String[] args) {
    }
}
