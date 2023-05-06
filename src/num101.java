public class num101 {
    public boolean dfs(TreeNode left, TreeNode right) {
        if(left!=null&&right!=null){
            if(left.val!=right.val)return false;
            return dfs(left.left, right.right)&&dfs(left.right, right.left);
        }else if(left==null&&right==null)return true;
        else return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}
