import java.util.Map;

public class num104 {
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public static void main(String[] args) {
        TreeNode a1 =new TreeNode(1);
        TreeNode a2 =new TreeNode(2);
        TreeNode a3 =new TreeNode(3);
        TreeNode a4 =new TreeNode(4);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        System.out.println(maxDepth(a1));

    }
}
