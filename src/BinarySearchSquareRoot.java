import java.util.HashSet;
import java.util.Set;

public class BinarySearchSquareRoot {
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("无法计算负数的平方根");
        }

        double left = 0.0;
        double right;
        if(x<1){
            right = 1;
        }else right = x;
        double epsilon = 1e-6; // 设定一个很小的精度值
        double mid = 0;

        while (right - left > epsilon) {
            mid = left + (right - left) / 2;
            double square = mid * mid;

            if (square < x) {
                left = mid;
            } else if(square>x) {
                right = mid;
            }else return mid;
        }
        return mid;
    }
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                maxLen = Math.max(maxLen,right-left);
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        double number = 0.5;
        double squareRoot = sqrt(number);
        System.out.println("平方根：" + squareRoot);
        String input = "abcabcbb";
        int length = lengthOfLongestSubstring(input);
        System.out.println("无重复字符的最长子串长度：" + length);
    }
}
