public class num979 {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){ //表示root需要向他的父亲节点转移的数量。
        if(root==null)return 0;
        int trans_left = 0;
        int trans_right = 0;
        if(root.left!=null){
            trans_left = dfs(root.left);
        }
        if(root.right!=null){
            trans_right = dfs(root.right);
        }
        ans += Math.abs(trans_left) + Math.abs(trans_right);
        return root.val+trans_left+trans_right-1;
    }
}
