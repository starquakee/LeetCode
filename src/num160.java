import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> list = new HashSet<>();
        ListNode cur = headA;
        while (cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur!=null){
            if(list.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
