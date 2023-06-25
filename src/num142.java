import java.util.HashSet;
import java.util.Set;

public class num142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(set.contains(cur)){
                return cur;
            }else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}
