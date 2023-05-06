
public class num2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    public static void printList(ListNode head) {
        ListNode curNode = head;
        while(curNode.next != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.println(curNode.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        ListNode l1_head = l1;
        ListNode l2_head = l2;
        int l1_len = 0;
        int l2_len = 0;
        while (l1.next!=null){
            l1_len+=1;
            l1 = l1.next;
        }
        while (l2.next!=null){
            l2_len+=1;
            l2 = l2.next;
        }
        if(l1_len>l2_len){
            for(int i=0;i<l1_len-l2_len;i++){
                l2.next = new ListNode(0);
                l2=l2.next;
            }
        }
        if(l1_len<l2_len){
            for(int i=0;i<l2_len-l1_len;i++){
                l1.next = new ListNode(0);
                l1=l1.next;
            }
        }
        printList(l1_head);
        printList(l2_head);
        l1 = l1_head;
        l2 = l2_head;
        int sum;
        int carry=0;
        for(int i=0;i<Math.max(l2_len,l1_len)+1;i++){
            sum = l1.val+l2.val+carry;
            if(sum>=10){
                carry=1;
                sum -= 10;
            }else {
                carry=0;
            }
            l1 = l1.next;
            l2 = l2.next;
            ans.val=sum;
            System.out.println(sum);
            if(i!=Math.max(l2_len,l1_len)){
                ans.next=new ListNode(0);
                ans = ans.next;
            }
        }
        if(carry==1){
            ans.next=new ListNode(1);
        }
        ans = head;
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(addTwoNumbers(l1, l2));
    }
}
