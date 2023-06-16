import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class num21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        List<Integer> l1 = ListNode2List(list1);
        List<Integer> l2 = ListNode2List(list2);
        List<Integer> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);
        Collections.sort(l);
        ListNode[] listNodes = new ListNode[l.size()];
        for(int i=0;i<l.size();i++){
            listNodes[i]=new ListNode(l.get(i));
        }
        for(int i=0;i<l.size()-1;i++){
            listNodes[i].next=listNodes[i+1];
        }
        return listNodes[0];
    }
    public List<Integer> ListNode2List(ListNode listNode){
        List<Integer> list = new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
