public class num82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode pre = new ListNode(-1);
        ListNode ans = pre;
        pre.next = head;
        while (head!=null&&head.next!=null){
            if(head.val==head.next.val){
                while ((head.next!=null&&head.val==head.next.val)){
                    head = head.next;
                }
                pre.next = head.next;
                head = head.next;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return ans.next;
    }
}
