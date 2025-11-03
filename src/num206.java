import java.util.ArrayList;
import java.util.List;

class num206 {
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
