import java.util.Objects;
import java.util.Stack;

public class num394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int place = 0;
        while (place<s.length()){
            if(Character.isDigit(s.charAt(place))){
                String num = String.valueOf(s.charAt(place));
                place++;
                while (Character.isDigit(s.charAt(place))){
                    num += String.valueOf(s.charAt(place));
                    place++;
                }
                stack.push(num);
            } else if (Character.isLetter(s.charAt(place))||s.charAt(place)=='[') {
                stack.push(String.valueOf(s.charAt(place)));
                place++;
            } else if (s.charAt(place) == ']') {
                place++;
                String temp = "";
                while (!Objects.equals(stack.peek(), "[")){
                    temp = stack.pop()+temp;
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                String tempWithTimes = "";
                for(int i=0;i<times;i++){
                    tempWithTimes += temp;
                }
                stack.push(tempWithTimes);
            }
        }
        String ans = "";
        while (!stack.isEmpty()){
            ans = stack.pop()+ans;
        }
        return ans;
    }
}
