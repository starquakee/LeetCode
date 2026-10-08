import java.util.ArrayDeque;
import java.util.Deque;

public class num1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')stack.push(c);
            else {
                if(stack.size()>1&&stack.peek()=='('){
                    stack.pop();
                }else if(stack.size()==1&&stack.peek()=='('){
                    stack.pop();
                    sb.append(s, l+1, i);
                    l=i+1;
                }
            }
        }
        return sb.toString();
    }
}
