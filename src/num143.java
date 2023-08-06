import java.util.ArrayList;
import java.util.List;

public class num143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp);
            temp = temp.next;
        }
        int left = 0;
        int right = list.size()-1;
        if(right==0)return;
        ListNode cur = null;
        while (left<right){
            if(cur!=null){
                cur.next = list.get(left);
            }
            list.get(left).next = list.get(right);
            cur = list.get(right);
            left++;
            right--;
        }
        if(cur!=null){
            cur.next = null;
        }
        if(left==right){
            cur.next = list.get(left);
            list.get(left).next = null;
        }
        temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
