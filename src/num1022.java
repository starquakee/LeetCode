public class num1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int num){
        if(root==null) return 0;
        num=num*2+root.val;
        if(root.left==null && root.right==null) return num;
        return dfs(root.left,num)+dfs(root.right,num);
    }
}
