import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class num17 {
    public static ListNode deleteDuplicationNode (ListNode pHead) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode current = pHead;
        ListNode head = new ListNode(0);
        ListNode ans = head;
        while (current!=null){
            map.putIfAbsent(current.val, 0);
            int num=map.get(current.val);
            num++;
            map.put(current.val, num);
            current = current.next;
        }
        current = pHead;
        while (current!=null){
            if(map.get(current.val)==1){
                head.next=new ListNode(current.val);
                head = head.next;
            }
            current = current.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {

    }
}
