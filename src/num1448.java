public class num1448 {
    public int goodNodes(TreeNode root) {
        return helper(root,-99999);
    }
    public int helper(TreeNode root,int max) {
        if(root == null)return 0;
        if(root.val>=max){
            max = root.val;
            return 1+helper(root.left,max)+helper(root.right,max);
        }else {
            return helper(root.left,max)+helper(root.right,max);
        }
    }
}
