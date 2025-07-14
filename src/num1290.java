public class num1290 {
    public int getDecimalValue(ListNode head) {
        int ans=head.val;
        while (head.next!=null){
            head=head.next;
            ans=ans*2+head.val;
        }
        return ans;
    }
}
