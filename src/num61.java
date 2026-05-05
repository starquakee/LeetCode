public class num61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len=0;
        ListNode temp=head;
        while (temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        if(len==0)return head;
        k=k%len;
        for(int i=0;i<len-k-1;i++) {
            temp = temp.next;
        }
        ListNode ans=temp.next;
        temp.next=null;
        temp=ans;
        if(ans==null)return head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next=head;
        return ans;
    }
}
