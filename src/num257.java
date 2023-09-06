import java.util.ArrayList;
import java.util.List;

public class num257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null)return list;
        dfs(root,list,"");
        return list;
    }
    public void dfs(TreeNode root,List<String> list,String temp){
        if(root.left==null&&root.right==null){
            temp+=root.val;
            list.add(temp);
            return;
        }
        if(root.left!=null){
            String newTemp = temp + root.val + "->";
            dfs(root.left,list,newTemp);
        }
        if(root.right!=null){
            String newTemp = temp + root.val + "->";
            dfs(root.right,list,newTemp);
        }
    }
}
