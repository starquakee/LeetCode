import java.util.HashSet;
import java.util.Set;

public class num2423 {
    public boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();
        int[] cnt = new int[26];
        for(char c:chars){
            cnt[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(cnt[i]==0){
                continue;
            }
            cnt[i]--;
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<26;j++){
                if(cnt[j]>0){
                    set.add(cnt[j]);
                }
            }
            if(set.size()==1){
                return true;
            }
            cnt[i]++;
        }
        return false;
    }
}
