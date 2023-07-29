import java.util.HashSet;
import java.util.Set;

public class num141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(!set.add(cur)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
