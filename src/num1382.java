import java.util.ArrayList;
import java.util.List;

public class num1382 {
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return null;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)<=1) {
            root.left = balanceBST(root.left);
            root.right = balanceBST(root.right);
            return root;
        }else {
            List<Integer> vals=new ArrayList<>();
            inorder(root,vals);
            return buildBalancedBST(vals,0,vals.size()-1);
        }
    }
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    public void inorder(TreeNode root,List<Integer> vals){
        if(root==null) return;
        inorder(root.left,vals);
        vals.add(root.val);
        inorder(root.right,vals);
    }
    public TreeNode buildBalancedBST(List<Integer> vals,int left,int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = buildBalancedBST(vals, left, mid - 1);
        node.right = buildBalancedBST(vals, mid + 1, right);
        return node;
    }
}
