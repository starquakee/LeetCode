import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num3403 {
    public String answerString(String word, int numFriends) {
        if (numFriends==1)return word;
        int maxLen=word.length()-numFriends+1;
        List<String> list = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            if(i+maxLen<word.length()){
                list.add(word.substring(i,i+maxLen));
            }else list.add(word.substring(i));
        }
        return Collections.max(list);
    }
}
