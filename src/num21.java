import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class num21 {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1==null){
//            return list2;
//        }else if(list2==null){
//            return list1;
//        }else {
//            if(list1.val< list2.val){
//                list1.next = mergeTwoLists(list1.next,list2);
//                return list1;
//            }else {
//                list2.next = mergeTwoLists(list1,list2.next);
//                return list2;
//            }
//        }
//    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode hair = new ListNode(-1);
        ListNode cur = hair;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                cur=cur.next;
                list1=list1.next;
            }else {
                cur.next=list2;
                cur=cur.next;
                list2=list2.next;
            }
        }
        if(list1==null){
            while (list2!=null){
                cur.next=list2;
                cur=cur.next;
                list2=list2.next;
            }
        }else{
            while (list1!=null){
                cur.next=list1;
                cur=cur.next;
                list1=list1.next;
            }
        }
        return hair.next;
    }
}
