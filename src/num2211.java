import java.util.Stack;

public class num2211 {
    public int countCollisions(String directions) {
        int n=directions.length();
        if(n==1) return 0;
        char[] chars = directions.toCharArray();
        Stack<Character> stack = new Stack<>();
        int ans=0;
        stack.push(chars[0]);
        for(int i=1;i<n;i++){
            if(stack.peek()=='R'&&chars[i]=='L'){
                ans+=2;
                stack.pop();
                while (!stack.isEmpty()&&stack.peek()=='R'){
                    ans++;
                    stack.pop();
                }
                stack.push('S');
            }else if(stack.peek()=='R'&&chars[i]=='S'){
                ans++;
                stack.pop();
                while (!stack.isEmpty()&&stack.peek()=='R'){
                    ans++;
                    stack.pop();
                }
                stack.push('S');
            }else if(stack.peek()=='S'&&chars[i]=='L'){
                ans++;
//                stack.push('S');
            }else stack.push(chars[i]);
        }
        return ans;
    }
}
