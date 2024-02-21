import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int ans = 0;
        for(String word:words){
            String rev = reverseString(word);
            if(set.contains(rev)&& !rev.equals(word)){
                ans++;
                set.remove(word);
            }
        }
        return ans;
    }
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }
}
