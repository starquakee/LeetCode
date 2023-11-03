import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
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
