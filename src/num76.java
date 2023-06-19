import java.util.HashMap;
import java.util.Map;

public class num76 {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int left_min=0;
        int right_min=0;
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        for(int i=0;i<t.length();i++){
            ori.putIfAbsent(t.charAt(i),0);
            ori.put(t.charAt(i),ori.get(t.charAt(i))+1);
        }
        while (right<s.length()){
            while (!check()){
                cnt.putIfAbsent(s.charAt(right),0);
                cnt.put(s.charAt(right),cnt.get(s.charAt(right))+1);
                right++;
                if(right==s.length()){
                    break;
                }
            }
            while (check()){
                if(right-left+1<min){
                    left_min=left;
                    right_min=right;
                }
                min = Math.min(min, right-left+1);
                cnt.put(s.charAt(left),cnt.get(s.charAt(left))-1);
                left++;
            }
        }
        return s.substring(left_min,right_min);
    }
    public boolean check() {
        for(Character character: ori.keySet()){
            if(cnt.getOrDefault(character,0)<ori.get(character)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        num76 solution = new num76();
        String result = solution.minWindow(s, t);

        System.out.println("Result: " + result);
    }

}
