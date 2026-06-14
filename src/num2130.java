public class num2130 {
    public int pairSum(ListNode head) {
        int n=0;
        ListNode cur=head;
        while(cur!=null) {
            n++;
            cur = cur.next;
        }
        int[] arr=new int[n];
        cur=head;
        for(int i=0;i<n;i++) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        int ans=0;
        for(int i=0;i<n/2;i++) {
            ans = Math.max(ans, arr[i] + arr[n - 1 - i]);
        }
        return ans;
    }
}
