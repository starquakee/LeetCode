//import java.util.Arrays;
//import java.util.Map;
//
////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.List;
////import java.util.Stack;
////
////class TreeNode {
////    int val = 0;
////    TreeNode left = null;
////    TreeNode right = null;
////    public TreeNode(int val) {
////         this.val = val;
////    }
////}
////public class num16 {
////    public static boolean isSubtree (TreeNode s, TreeNode t) { //dfs
////        String a = dfs(s);
////        String b = dfs(t);
////        return a.contains(b);
////    }
////    public static String dfs(TreeNode treeNode){
////        Stack<TreeNode> stack = new Stack<>();
////        stack.push(treeNode);
////        String ans = "";
////        while (!stack.isEmpty()){
////            TreeNode temp = stack.pop();
////            if(temp.right!=null){
////                stack.push(temp.right);
////            }
////            if(temp.left!=null){
////                stack.push(temp.left);
////            }
////            ans += temp.val;
////        }
////        return ans;
////    }
////    public static int threeSumClosest(int[] nums, int target) {
////        Arrays.sort(nums);
////        System.out.println(Arrays.toString(nums));
////        int ans = 999999999;
////        for(int i=0;i< nums.length-2;i++){
////            int pa = i+1;
////            int pb = nums.length-1;
////            while (pb>pa){
////                if(nums[i]+nums[pa]+nums[pb]>target){
////                    if(nums[i]+nums[pa]+nums[pb]-target<Math.abs(target-ans)){
////                        System.out.println(i+" "+pa+" "+pb);
////                        ans = nums[i]+nums[pa]+nums[pb];
////                    }
////                    pb--;
////                }else if(nums[i]+nums[pa]+nums[pb]<target){
////                    if(target-nums[i]-nums[pa]-nums[pb]<Math.abs(target-ans)){
////                        System.out.println(i+" "+pa+" "+pb);
////                        ans = nums[i]+nums[pa]+nums[pb];
////                    }
////                    pa++;
////                }else return target;
////            }
////
////        }
////        return ans;
////    }
////    public List<String> char_list(char c) {
////        List<String> a1 = new ArrayList<>();
////        switch (c) {
////            case '2':
////                a1.add("a");
////                a1.add("b");
////                a1.add("c");
////                break;
////            case '3':
////                a1.add("d");
////                a1.add("e");
////                a1.add("f");
////                break;
////            case '4':
////                a1.add("g");
////                a1.add("h");
////                a1.add("i");
////                break;
////            case '5':
////                a1.add("j");
////                a1.add("k");
////                a1.add("l");
////                break;
////            case '6':
////                a1.add("m");
////                a1.add("n");
////                a1.add("o");
////                break;
////            case '7':
////                a1.add("p");
////                a1.add("q");
////                a1.add("r");
////                a1.add("s");
////                break;
////            case '8':
////                a1.add("t");
////                a1.add("u");
////                a1.add("v");
////                break;
////            case '9':
////                a1.add("w");
////                a1.add("x");
////                a1.add("y");
////                a1.add("z");
////                break;
////        }
////        return a1;
////    }
////    public List<String> letterCombinations(String digits) {
////        List<String> ans = new ArrayList<>();
////        if(digits.length()==0) return ans;
////        else if (digits.length() == 1) {
////            List<String> a1 = char_list(digits.charAt(0));
////            for(int i = 0;i<a1.size();i++){
////                ans.add(a1.get(i));
////            }
////            return ans;
////        } else if (digits.length() == 2) {
////            List<String> a1 = char_list(digits.charAt(0));
////            List<String> a2 = char_list(digits.charAt(1));
////            for (String value : a1) {
////                for (String s : a2) {
////                    ans.add(value + s);
////                }
////            }
////            return ans;
////        }
////        else if (digits.length() == 3) {
////            List<String> a1 = char_list(digits.charAt(0));
////            List<String> a2 = char_list(digits.charAt(1));
////            List<String> a3 = char_list(digits.charAt(2));
////            for (String s1 : a1) {
////                for (String s2 : a2) {
////                    for(String s3 : a3){
////                        ans.add(s1 + s2 + s3);
////                    }
////                }
////            }
////            return ans;
////        }
////        else if (digits.length() == 4) {
////            List<String> a1 = char_list(digits.charAt(0));
////            List<String> a2 = char_list(digits.charAt(1));
////            List<String> a3 = char_list(digits.charAt(2));
////            List<String> a4 = char_list(digits.charAt(3));
////            for (String s1 : a1) {
////                for (String s2 : a2) {
////                    for(String s3 : a3){
////                        for(String s4 : a4){
////                            ans.add(s1 + s2 + s3 + s4);
////                        }
////                    }
////                }
////            }
////            return ans;
////        }
////        return ans;
////    }
////    public static void main(String[] args) {
////        TreeNode a1 = new TreeNode(3);
////        TreeNode a2 = new TreeNode(4);
////        TreeNode a3 = new TreeNode(5);
////        TreeNode a4 = new TreeNode(1);
////        TreeNode a5 = new TreeNode(2);
////        TreeNode a6 = new TreeNode(0);
////        a1.left=a2;
////        a1.right=a3;
////        a2.left=a4;
////        a2.right=a5;
////        a4.left=a6;
////        int[] a = new int[]{-1,2,1,-4};
////        System.out.println(threeSumClosest(a,4));
//////        System.out.println(isSubtree());
////
////    }
////}
//class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        int ans = Integer.MIN_VALUE;
//        int n= nums.length;
//        Arrays.sort(nums);
//        for(int i1=0;i1<=n-3;i1++){
//            for(int i2=i1+1;i2<=n-2;i2++){
//                int i3 = n-1;
//                int sum = nums[i1]+nums[i2]+nums[i3];
//                System.out.println(i1+" "+i2+" "+i3);
//                while (sum-target>0&&i3>i2){
//                    sum = nums[i1]+nums[i2]+nums[i3];
//                    if(Math.abs(target-ans)>Math.abs(target-sum)){
//                        System.out.println(Math.abs(target-ans));
//                        System.out.println(Math.abs(target-sum));
//                        ans = sum;
//                    }
//                    if(ans==target)return ans;
//                    i3--;
//                }
//                if(i3>i2){
//                    sum = nums[i1]+nums[i2]+nums[i3];
//                    if(Math.abs(target-ans)>Math.abs(target-sum)){
//                        ans = sum;
//                    }
//                    if(ans==target)return ans;
//                }
//            }
//        }
//        return ans;
//    }
//}
