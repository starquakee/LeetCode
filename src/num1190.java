import java.util.ArrayDeque;

public class num1190 {
    public String reverseParentheses(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp!=')'){
                stack.push(String.valueOf(temp));
            }else {
                StringBuilder sbTemp = new StringBuilder();
                while (!stack.isEmpty()){
                    String pop = stack.pop();
                    if(!pop.equals("(")) sbTemp.insert(0,pop);
                    else {
                        sbTemp.reverse();
                        stack.push(sbTemp.toString());
                        System.out.println(sbTemp.toString());
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
