public class num543 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        heightOfBinaryTree(root);
        return max-1;
    }

    public int heightOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int L=heightOfBinaryTree(root.left);
        int R=heightOfBinaryTree(root.right);
        max = Math.max(max, L+R+1);
        return Math.max(L,R)+1;
    }
}
