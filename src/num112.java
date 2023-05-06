public class num112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return targetSum==root.val;
        } else if (root.left != null && root.right != null) {
            return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
        } else if (root.left == null) {
            return hasPathSum(root.right,targetSum-root.val);
        } else {
            return hasPathSum(root.left,targetSum- root.val);
        }
    }
    public static void main(String[] args) {

    }
}
