import java.util.HashMap;
import java.util.Map;

public class num82 {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head==null)return null;
//        ListNode pre = new ListNode(-1);
//        ListNode ans = pre;
//        pre.next = head;
//        while (head!=null&&head.next!=null){
//            if(head.val==head.next.val){
//                while ((head.next!=null&&head.val==head.next.val)){
//                    head = head.next;
//                }
//                pre.next = head.next;
//                head = head.next;
//            }else {
//                pre = head;
//                head = head.next;
//            }
//        }
//        return ans.next;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode curr=head;
        while (curr!=null){
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr=curr.next;
        }
        ListNode hair=new ListNode(-1,head);
        curr=hair;
        while (curr.next!=null){
            ListNode next=curr.next;
            if(map.get(next.val)>1){
                curr.next=next.next;
            }else curr=curr.next;
        }
        return hair.next;
    }
}
