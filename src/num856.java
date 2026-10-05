import java.util.ArrayDeque;
import java.util.Deque;

public class num856 {
    public int scoreOfParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else {
                if(stack.peek()=='('){
                    stack.pop();
                    stack.push('1');
                }else {
                    int temp=0;
                    while (stack.peek()!='('){
                        temp+=stack.pop()-'0';
                    }
                    stack.pop();
                    stack.push((char) (2*temp+'0'));
                }
            }
        }
        while (!stack.isEmpty()) ans+=stack.pop()-'0';
        return ans;
    }
}
