import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class num138 {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(!map.containsKey(head)){
            Node node_new = new Node(head.val);
            map.put(head, node_new);
            node_new.next = copyRandomList(head.next);
            node_new.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
