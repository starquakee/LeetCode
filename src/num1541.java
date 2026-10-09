public class num1541 {
    public int minInsertions(String s) {
        int ans = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) { // 之前有落单的右括号
                    ans++;
                    need--;
                }
            } else {
                need--;
                if (need == -1) {
                    ans++;
                    need = 1;
                }
            }
        }
        return ans + need;
    }
}
