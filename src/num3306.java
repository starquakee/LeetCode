import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num3306 {
    public long helper(String word, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        long ans = 0;
        int n = word.length();
        int j=0;
        int num=0;
        for(int i=0;i<n;i++){
            while (j<n&&(num<k||map.size()<5)){
                char ch=word.charAt(j);
                if(vowels.contains(ch)){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }else {
                    num++;
                }
                j++;
            }
            if(num>=k&&map.size()==5){
                ans+=n-j+1;
            }
            char left=word.charAt(i);
            if(vowels.contains(left)){
                map.put(left,map.getOrDefault(left,0)-1);
                if(map.get(left)==0)map.remove(left);
            }else {
                num--;
            }
        }
        return ans;
    }
    public long countOfSubstrings(String word,int k){
        return helper(word,k)-helper(word,k+1);
    }
}
