//import java.util.*;
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
//public class num116 {
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Node r = root;
//        List<Node> list = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            Node temp =queue.poll();
//            list.add(temp);
//            if(temp.left!=null){
//                queue.add(temp.left);
//                queue.add(temp.right);
//            }
//        }
//        int depth=1;
//        while (Math.pow(2,depth-1)<list.size()){
//            for(int i = (int) (Math.pow(2,depth-1)-1); i<Math.pow(2,depth)-2; i++){
//                list.get(i).next=list.get(i+1);
//            }
//            list.get((int) (Math.pow(2,depth)-2)).next=null;
//            depth++;
//        }
//        return r;
//    }
//    public static void main(String[] args) {
//
//    }
//}
