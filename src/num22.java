import java.util.ArrayList;
import java.util.List;

public class num22 {
    public List<String> generateParenthesis(int n) {
        List<String> strings = generateAllPossibleStrings(2*n);
        List<String> ans = new ArrayList<>();
        strings.forEach(e->{
            if(valid(e)){
                ans.add(e);
            }
        });
        return ans;
    }

    public static List<String> generateAllPossibleStrings(int n) {
        List<String> result = new ArrayList<>();
        generateAllPossibleStringsHelper(n, "", result);
        return result;
    }

    private static void generateAllPossibleStringsHelper(int n, String currentString, List<String> result) {
        if (currentString.length() == n) {
            result.add(currentString);
            return;
        }
//二叉树结构
        generateAllPossibleStringsHelper(n, currentString + "(", result);
        generateAllPossibleStringsHelper(n, currentString + ")", result);
    }
    public boolean valid(String current) {
        int balance = 0;
        for (char c: current.toCharArray()) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static void main(String[] args) {
        int n = 6;
        List<String> strings = generateAllPossibleStrings(n);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
