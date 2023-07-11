public class num19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getListNodeLength(head);
        ListNode begin = new ListNode(-1);
        begin.next = head;
        ListNode current = begin;
        for(int i=0;i<length-n;i++){
            current=current.next;
        }
        current.next = current.next.next;
        return begin.next;
    }
    public int getListNodeLength(ListNode listNode){
        int ans = 0;
        while (listNode != null){
            listNode = listNode.next;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "aaabbb";
        String b = "aaabbb";
        System.out.println(a.equals(new String("aaabbb")));
    }
}