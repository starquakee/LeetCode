import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=slow){
            if(fast==null||fast.next==null)return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }
}
