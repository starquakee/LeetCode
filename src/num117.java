//import java.util.*;
//
//class Node_dep {
//    public int depth;
//    public Node node;
//    public Node_dep() {}
//
//    public Node_dep(Node node, int depth) {
//        this.node = node;
//        this.depth = depth;
//    }
//
//
//};
//public class num117 {
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Node r = root;
//        List<Node_dep> list = new ArrayList<>();
//        Queue<Node_dep> queue = new LinkedList<>();
//        queue.add(new Node_dep(root,1));
//        while (!queue.isEmpty()){
//            Node_dep temp =queue.poll();
//            list.add(temp);
//            System.out.println(temp.node.val);
//            if(temp.node.left!=null){
//                queue.add(new Node_dep(temp.node.left, temp.depth+1));
//            }
//            if(temp.node.right!=null){
//                queue.add(new Node_dep(temp.node.right, temp.depth+1));
//            }
//        }
//        for(int i=0;i<list.size()-1;i++){
//            System.out.println(list.get(i).node.val);
//            if(list.get(i).depth==list.get(i+1).depth){
//                list.get(i).node.next=list.get(i+1).node;
//            }else list.get(i).node.next=null;
//        }
//        list.get(list.size()-1).node.next=null;
//        return r;
//    }
//    public static void main(String[] args) {
//
//    }
//}
