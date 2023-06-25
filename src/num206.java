public class num206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        ListNode temp = new ListNode(cur.val);
        cur = cur.next;
        while (cur!=null){
            temp = new ListNode(cur.val, temp);
            cur = cur.next;
        }
        return temp;
    }
}
