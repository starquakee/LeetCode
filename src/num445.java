import java.util.ArrayDeque;
import java.util.Deque;

public class num445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry = 0;
        ListNode next = null;
        while (!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            int num1=0,num2=0;
            if(!stack1.isEmpty()){
                num1=stack1.poll();
            }
            if(!stack2.isEmpty()){
                num2=stack2.poll();
            }
            int sum = num1+num2+carry;
            carry = sum/10;
            int val = sum%10;
            ListNode cur = new ListNode(val);
            cur.next = next;
            next = cur;

        }
        return next;
    }
}
