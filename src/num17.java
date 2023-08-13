import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class num17 {
    public static ListNode deleteDuplicationNode (ListNode pHead) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode current = pHead;
        ListNode head = new ListNode(0);
        ListNode ans = head;
        while (current!=null){
            map.putIfAbsent(current.val, 0);
            int num=map.get(current.val);
            num++;
            map.put(current.val, num);
            current = current.next;
        }
        current = pHead;
        while (current!=null){
            if(map.get(current.val)==1){
                head.next=new ListNode(current.val);
                head = head.next;
            }
            current = current.next;
        }
        return ans.next;
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        back(phoneMap,combinations,"",0,digits);
        return combinations;
    }
    public void back(Map<Character, String> phoneMap,List<String> combinations,String combination,int index,String digits){
        if(digits.length()==index){
            combinations.add(combination);
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for(int i=0;i<letters.length();i++){
                combination += letters.charAt(i);
                back(phoneMap,combinations,combination,index+1,digits);
                combination = combination.substring(0,combination.length()-1);
            }
        }
    }
}
