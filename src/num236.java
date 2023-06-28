import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num236 {
    Map<Integer, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public void dfs(TreeNode root){
        if(root.left!=null){
            parents.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parents.put(root.right.val,root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p = parents.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            visited.add(q.val);
            q = parents.get(q.val);
        }
        return null;
    }
}
