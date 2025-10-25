public class num25 {
//    public ListNode reverseList(ListNode head,int k) {
//        ListNode prev = null;
//        ListNode curr = head;
//        int i=0;
//        while (i<k) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            i++;
//        }
//        return prev;
//    }
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode h = head;
//        for(int i=0;i<k;i++){
//            if(h==null){
//                return head;
//            }
//            h = h.next;
//        }
//        ListNode cur_next= head;
//        for(int i=0;i<k-1;i++){
//            cur_next=cur_next.next;
//        }
//        ListNode start = cur_next.next;
//        reverseList(head,k);
//        head.next = reverseKGroup(start,k);
//        return cur_next;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (pre != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode[] listNodes = myReverse(pre.next, tail);
            ListNode newHead = listNodes[0];
            ListNode newTail = listNodes[1];
            pre.next = newHead;
            pre = newTail;
        }
        return hair.next;
    }
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode curr=head;
        while (pre!=tail){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return new ListNode[]{pre,head};
    }
}
