import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class num2487 {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode ans = head;
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        int max = Integer.MIN_VALUE;
        for(int i=list.size()-1;i>=0;i--){
            max = Math.max(max,list.get(i));
            arr[i] = max;
        }
        ListNode iter = ans;
        ans = new ListNode(-1);
        ans.next = iter;
        ListNode pre = ans;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<arr[i]){
                pre.next = iter.next;
            }else pre = pre.next;
            iter = iter.next;
        }
        return ans.next;
    }
}
