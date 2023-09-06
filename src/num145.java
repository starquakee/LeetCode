import java.util.ArrayList;
import java.util.List;

public class num145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        post(root,list);
        return list;
    }
    public void post(TreeNode root,List<Integer> list){
        if(root==null)return;
        post(root.left,list);
        post(root.right,list);
        list.add(root.val);
    }
}
