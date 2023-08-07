import java.util.ArrayList;
import java.util.List;

public class num235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root,p);
        List<TreeNode> path_q = getPath(root,q);
        TreeNode ans = null;
        for(int i=0;i<path_p.size()&&i<path_q.size();i++){
            if(path_p.get(i)==path_q.get(i)){
                ans = path_p.get(i);
            }else break;
        }
        return ans;
    }
    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> list = new ArrayList<>();
        while (root!=target){
            if(root.val<target.val){
                list.add(root);
                root = root.right;
            }else {
                list.add(root);
                root = root.left;
            }
        }
        list.add(root);
        return list;
    }
}
