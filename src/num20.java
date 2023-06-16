import java.util.Stack;

public class num20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(s.charAt(0)));
        for(int i=1;i<s.length();i++){
            if(!stack.isEmpty()){
                if(isPair(stack.peek(),String.valueOf(s.charAt(i)))){
                    stack.pop();
                }else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            }else stack.push(String.valueOf(s.charAt(i)));

        }
        return stack.isEmpty();
    }
    public boolean isPair(String a, String b){
        if(a.equals("(")&&b.equals(")")){
            return true;
        }
        if(a.equals("[")&&b.equals("]")){
            return true;
        }
        return a.equals("{") && b.equals("}");
    }
}
