public class num124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    public int maxGain(TreeNode root){
        if(root ==null)return 0;
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        int Gain = leftGain+root.val+rightGain;
        max = Math.max(max, Gain);
        return root.val+Math.max(leftGain,rightGain);
    }
}
