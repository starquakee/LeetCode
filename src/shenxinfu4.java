import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class shenxinfu4 {
    public static void helper(String input ,String output,Stack<Character> stack,List<String> ans,int size){
        if(input.isEmpty()&&stack.isEmpty()&&input.length()==size){
            ans.add(output);
            return;
        }
        if(!stack.isEmpty()){
            Stack<Character> clone = (Stack<Character>) stack.clone();
            char popped = clone.pop();
            helper(input,output+popped,clone,ans,size);
        }
        if(!input.isEmpty()){
            Stack<Character> clone = (Stack<Character>) stack.clone();
            char next = input.charAt(0);
            helper(input.substring(1),output,clone,ans,size);
            clone.push(next);
            helper(input.substring(1),output,clone,ans,size);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        List<String> list = new ArrayList<>();
        helper(s,"",new Stack<>(),list,s.length());
        for(String ans:list){
            System.out.println(ans);
        }
    }
}
