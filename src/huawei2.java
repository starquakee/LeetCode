//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//class Node{
//    int val;
//    Node next;
//    Node pre;
//    boolean in;
//    public Node(int val){
//        this.val=val;
//        this.in = true;
//    }
//}
//public class huawei2 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int start = input.nextInt();
//        int end = input.nextInt();
//        Node[] nodes = new Node[end+2];
//        Node begin_null=new Node(-1);
//        Node end_null=new Node(-2);
//        for(int i=0;i<end+1;i++){
//            nodes[i]=new Node(i);
//            if(i>0){
//                nodes[i].pre = nodes[i-1];
//            }else nodes[0].pre=begin_null;
//        }
//
//        for(int i=0;i<end+1;i++){
//            nodes[i].next=nodes[i+1];
//        }
//        int num = input.nextInt();
//        Node head = nodes[1];
//        Node tail =nodes[end];
//        tail.next=end_null;
//        for(int i=0;i<num;i++){
//            int type=input.nextInt();
//            int value=input.nextInt();
//            if(type==1){
//                for(int j=0;j<value;j++){
//                    if(head.val>0){
//                        head.in=false;
//                        head=head.next;
//                        head.pre=begin_null;
//                    }
//                }
//            } else if (type == 2) {
//                if(nodes[value].in){
//                    if(value!= head.val&&value!=tail.val){
//                        nodes[value].pre.next=nodes[value].next;
//                        nodes[value].next.pre=nodes[value].pre;
//                        nodes[value].in=false;
//                    }else if(value== head.val){
//                        head.in=false;
//                        head = head.next;
//                        head.pre=begin_null;
//                    } else if (value == tail.val) {
//                        tail.in=false;
//                        tail=tail.pre;
//                        tail.next=end_null;
//
//                    }
//                }
//
//            } else if (type == 3) {
//                if(!nodes[value].in){
//                    tail.next=nodes[value];
//                    nodes[value].pre=tail;
//                    tail=tail.next;
//                    tail.in=true;
//                    tail.next=end_null;
//                }
//
//            }
//        }
//        System.out.println(head.val);
//
//    }
//
//}
