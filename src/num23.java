import java.util.*;

public class num23 {
//    public ListNode mergeKLists(ListNode[] lists) {
////        if(list1==null&&list2==null){
////            return null;
////        }
//        List<Integer> l = new ArrayList<>();
//        for (ListNode list : lists) {
//            l.addAll(ListNode2List(list));
//        }
//        Collections.sort(l);
//        if(l.size()==0) return null;
//        ListNode[] listNodes = new ListNode[l.size()];
//        for(int i=0;i<l.size();i++){
//            listNodes[i]=new ListNode(l.get(i));
//        }
//        for(int i=0;i<l.size()-1;i++){
//            listNodes[i].next=listNodes[i+1];
//        }
//        return listNodes[0];
//    }
//    public List<Integer> ListNode2List(ListNode listNode){
//        List<Integer> list = new ArrayList<>();
//        while (listNode!=null){
//            list.add(listNode.val);
//            listNode = listNode.next;
//        }
//        return list;
//    }
static class Status implements Comparable<Status>{
        int val;
        ListNode listNode;
        Status(int val,ListNode listNode){
            this.val = val;
            this.listNode = listNode;
        }

    @Override
    public int compareTo(Status o) {
        return this.val-o.val;
    }
}
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> priorityQueue = new PriorityQueue<>();
        for(ListNode listNode:lists){
            if(listNode!=null){
                priorityQueue.offer(new Status(listNode.val, listNode));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!priorityQueue.isEmpty()){
            ListNode small = priorityQueue.poll().listNode;
            tail.next = small;
            if(small.next!=null){
                priorityQueue.offer(new Status(small.next.val, small.next));
            }
            tail = tail.next;
        }
        return head.next;
    }
}
