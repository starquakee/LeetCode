public class num1123 {
//    public TreeNode lcaDeepestLeaves(TreeNode root) {
//        return dfs(root).getKey();
//    }
//    public Pair<TreeNode,Integer> dfs(TreeNode root){
//        if(root==null){
//            return new Pair<>(null,0);
//        }
//        Pair<TreeNode,Integer> left = dfs(root.left);
//        Pair<TreeNode,Integer> right = dfs(root.right);
//        if(left.getValue()>right.getValue()){
//            return new Pair<>(left.getKey(),left.getValue()+1);
//        }else if(left.getValue()<right.getValue()){
//            return new Pair<>(right.getKey(),right.getValue()+1);
//        }else return new Pair<>(root,left.getValue()+1);
//    }
    static class Result {
        TreeNode node;
        int depth;
        public Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        // 递归出口
        if (root == null) {
            return new Result(null, 0);
        }
        // 计算左、右子树的 "最近公共祖先" 和 "最大深度"
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth) {
            // 左子树更深，公共祖先一定在左子树
            return new Result(left.node, left.depth + 1);
        } else if (left.depth < right.depth) {
            // 右子树更深，公共祖先一定在右子树
            return new Result(right.node, right.depth + 1);
        } else {
            // 左右子树深度相等，当前节点就是最深公共祖先
            return new Result(root, left.depth + 1);
        }
    }
}
