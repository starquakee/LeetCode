import java.util.ArrayList;
import java.util.List;

public class num144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        pre(root,list);
        return list;
    }
    public void pre(TreeNode root,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);
    }
}
