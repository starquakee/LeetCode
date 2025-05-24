import java.util.ArrayList;
import java.util.List;

public class num2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].contains(String.valueOf(x))){
                ans.add(i);
            }
        }
        return ans;
    }
}
