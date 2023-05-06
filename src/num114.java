import java.util.ArrayList;
import java.util.List;

public class num114 {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root==null) return;
        preorder(root);
        for(int i=0;i<list.size();i++){
            if(i+1<list.size()){
                list.get(i).right=list.get(i+1);
            }else list.get(i).right=null;
            list.get(i).left=null;
        }
    }
    public void preorder(TreeNode root){
        if(root==null) return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

    }
}
