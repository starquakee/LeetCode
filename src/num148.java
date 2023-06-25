import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num148 {
    public ListNode sortList(ListNode head) {
        if(head==null)return null;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        };
        list.sort(comparator);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;
        return list.get(0);
    }
}
