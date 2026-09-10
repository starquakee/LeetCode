public class num2265 {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] l=dfs(root.left);
        int[] r=dfs(root.right);
        if((l[0]+r[0]+root.val)/(l[1]+r[1]+1)==root.val)ans++;
        return new int[]{l[0]+r[0]+root.val,l[1]+r[1]+1};
    }
}
