public class num2095 {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode hat = new ListNode(-1,head);
        ListNode slow=hat,fast=hat.next;
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
