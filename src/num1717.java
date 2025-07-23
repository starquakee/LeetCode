import java.util.Stack;

public class num1717 {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculateScore(s, "ab", x, "ba", y);
        } else {
            return calculateScore(s, "ba", y, "ab", x);
        }
    }

    private int calculateScore(String s, String highPriorityStr, int highPriorityVal, String lowPriorityStr, int lowPriorityVal) {
        int totalScore = 0;

        StringBuilder round1Builder = new StringBuilder();
        char highFirst = highPriorityStr.charAt(0);
        char highSecond = highPriorityStr.charAt(1);

        // 第一轮：移除所有高分组合
        for (char c : s.toCharArray()) {
            if (round1Builder.length() > 0 && round1Builder.charAt(round1Builder.length() - 1) == highFirst && c == highSecond) {
                round1Builder.deleteCharAt(round1Builder.length() - 1);
                totalScore += highPriorityVal;
            } else {
                round1Builder.append(c);
            }
        }

        // 第二轮：在第一轮剩下的字符串中，移除所有低分组合
        StringBuilder round2Builder = new StringBuilder();
        char lowFirst = lowPriorityStr.charAt(0);
        char lowSecond = lowPriorityStr.charAt(1);

        for (char c : round1Builder.toString().toCharArray()) {
            if (round2Builder.length() > 0 && round2Builder.charAt(round2Builder.length() - 1) == lowFirst && c == lowSecond) {
                round2Builder.deleteCharAt(round2Builder.length() - 1);
                totalScore += lowPriorityVal;
            } else {
                round2Builder.append(c);
            }
        }

        return totalScore;
    }
}
