import java.util.HashMap;
import java.util.Map;

public class num106 {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length-1,0,inorder.length-1);

    }
    public TreeNode helper(int[] inorder, int[] postorder, int in_begin, int in_end,int post_begin,int post_end){
        if(post_begin>post_end)return null;
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[post_end]);
        int in_root = map.get(postorder[post_end]);
        root.left = helper(inorder,postorder,in_begin,in_root-1,post_begin,post_begin+in_root-in_begin-1);
        root.right = helper(inorder,postorder,in_root+1,in_end,post_begin+in_root-in_begin,post_end-1);
        return root;
    }
}
