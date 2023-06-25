public class num24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null)return head;
        ListNode cur = head;
        ListNode cur_next = cur.next;
        cur.next = swapPairs(cur_next.next);
        cur_next.next = cur;
        return cur_next;
    }
}
