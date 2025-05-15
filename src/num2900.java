import java.util.ArrayList;
import java.util.List;

public class num2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int pre=-1;
        for(int i=0;i< words.length;i++){
            if(groups[i]!=pre){
                ans.add(words[i]);
                pre=groups[i];
            }
        }
        return ans;
    }
}
