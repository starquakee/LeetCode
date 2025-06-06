import java.util.Stack;

public class num2434 {
    public String robotWithString(String s) {
        int n=s.length();
        StringBuilder sb = new StringBuilder();
        int[] arr= new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        char cMin = 'a';
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            stack.add(temp);
            arr[temp-'a']--;
            while (cMin<'z'&&arr[cMin-'a']==0){
                cMin++;
            }
            while (!stack.isEmpty()&&stack.peek()<=cMin){
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
}
