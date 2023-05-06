public class num110 {
    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null)return true;
        if(root.left!=null&&root.right!=null){
            if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1)return false;
            else return isBalanced(root.left)&&isBalanced(root.right);
        }else if(root.left==null){
            return maxDepth(root.right) <= 1;
        }
        else {
            return maxDepth(root.left) <= 1;
        }
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public static void main(String[] args) {

    }
}
