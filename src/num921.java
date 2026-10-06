import java.util.ArrayDeque;
import java.util.Deque;

public class num921 {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='('){
                while (!stack.isEmpty()&&stack.peek()==')'){
                    stack.pop();
                    ans++;
                }
                stack.push('(');
            }else {
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else {
                    stack.push(')');
                }
            }
        }
        while (!stack.isEmpty()){
            stack.pop();
            ans++;
        }
        return ans;
    }
}
