import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num2785 {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> indexList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        List<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        for (int i = 0; i < chars.length; i++) {
            if(vowelList.contains(Character.toLowerCase(chars[i]))) {
                charList.add(chars[i]);
                indexList.add(i);
            }
        }
        Collections.sort(charList);
        for(int i = 0; i < charList.size(); i++) {
            chars[indexList.get(i)] = charList.get(i);
        }
        return String.valueOf(chars);
    }
}
