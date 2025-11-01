import java.util.HashSet;
import java.util.Set;

public class num3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode hair=new ListNode(0,head);
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        ListNode cur=hair;
        while (cur.next!=null){
            if(set.contains(cur.next.val)){
                cur.next=cur.next.next;
            }else cur=cur.next;
        }
        return hair.next;
    }
}
