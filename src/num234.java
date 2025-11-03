import java.util.ArrayList;
import java.util.List;

public class num234 {
    public boolean isPalindrome(ListNode head) {
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        cur=head;
        ListNode firstHalfLast=head;
        for (int i = 0; i < len/2; i++) {
            cur=cur.next;
            if(i==len/2-2)firstHalfLast=cur;
        }
        ListNode half=cur;
        half=reverseList(half);
        cur=head;
        while (half!=null&&cur!=null){
            if(half.val!=cur.val)return false;
            half=half.next;
            cur=cur.next;
        }
        half=reverseList(half);
        firstHalfLast.next=half;
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
