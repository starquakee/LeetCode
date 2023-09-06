public class num129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int preSum){
        if(root==null)return 0;
        int sum = 10*preSum+root.val;
        if(root.left!=null||root.right!=null){
            return dfs(root.left,sum)+dfs(root.right,sum);
        }else return sum;
    }
}
