
class num98 {
    long com = -9999999999L;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        System.out.println(-1);
        if(!isValidBST(root.left)) return false;
        System.out.println(-2);
        System.out.println(com);
        System.out.println(root.val);

        if(root.val<=com) return false;
        System.out.println(-3);
        com=root.val;
        return isValidBST(root.right);
    }
}