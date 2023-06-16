import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class num23 {
    public ListNode mergeKLists(ListNode[] lists) {
//        if(list1==null&&list2==null){
//            return null;
//        }
        List<Integer> l = new ArrayList<>();
        for (ListNode list : lists) {
            l.addAll(ListNode2List(list));
        }
        Collections.sort(l);
        if(l.size()==0) return null;
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
