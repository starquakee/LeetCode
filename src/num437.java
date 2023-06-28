public class num437 {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return ans;
        rootSum(root,targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }
    public int rootSum(TreeNode root, long targetSum) {
        if(root==null)return ans;
        if(root.val==targetSum){
            ans++;
        }
        rootSum(root.left, targetSum-root.val);
        rootSum(root.right, targetSum-root.val);
        return ans;
    }
}
