public class num110 {
//    public static boolean isBalanced(TreeNode root) {
//        if(root==null) return true;
//        if(root.left==null&&root.right==null)return true;
//        if(root.left!=null&&root.right!=null){
//            if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1)return false;
//            else return isBalanced(root.left)&&isBalanced(root.right);
//        }else if(root.left==null){
//            return maxDepth(root.right) <= 1;
//        }
//        else {
//            return maxDepth(root.left) <= 1;
//        }
//    }
//    public static int maxDepth(TreeNode root) {
//        if(root==null) return 0;
//        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//    }
    public static boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    public static int depth(TreeNode root){ //计算当前节点的深度，如果不平衡返回-1
        if(root==null) return 0;
        int left=depth(root.left);
        if(left==-1)return -1;
        int right=depth(root.right);
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
