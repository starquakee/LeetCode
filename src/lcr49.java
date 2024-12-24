public class lcr49 {
    //dfs
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int preSum){
        if(root==null)return 0;
        int sum = 10*preSum+root.val;
        if(root.left==null&&root.right==null)return sum;
        return dfs(root.left, sum)+dfs(root.right,sum);
    }
}
