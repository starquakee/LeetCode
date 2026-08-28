public class num3734 {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        // 特殊情况：长度为1
        if (n == 1) {
            return s.compareTo(target) > 0 ? s : "";
        }

        // 统计每个字符的出现次数
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // 检查是否能构成回文串，并记录奇数个的字符
        String oddChar = "";
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                // 超过一个字符出现奇数次，无法构成回文
                if (oddChar != "") {
                    return "";
                }
                oddChar = String.valueOf((char)('a' + i));
            }
            cnt[i] /= 2;  // 只需要一半的字符来构造左半部分
        }

        StringBuilder prefix = new StringBuilder();

        // 贪心构造左半部分的每一位
        for (int i = 0; i < n / 2; i++) {
            boolean found = false;
            // 尝试放置字典序最小的字符
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0) {
                    continue;
                }

                cnt[j]--;
                if (check(prefix.toString(), (char)('a' + j), cnt, oddChar, target)) {
                    // 如果构造的回文串大于target，则选择该字符
                    prefix.append((char)('a' + j));
                    found = true;
                    break;
                } else {
                    cnt[j]++;  // 不满足条件，恢复计数
                }
            }
            if (!found) {
                return "";  // 无法构造出大于target的回文串
            }

            if (prefix.charAt(i) > target.charAt(i)) {  // prefix已经大于target
                StringBuilder left = new StringBuilder(prefix);
                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < cnt[j]; k++) {
                        left.append((char)('a' + j));
                    }
                }
                String palindrome = left.toString() + oddChar + new StringBuilder(left).reverse().toString();
                return palindrome;
            }
        }

        // 构造最终的回文串
        String ans = prefix.toString() + oddChar + new StringBuilder(prefix).reverse().toString();
        return ans;
    }

    private boolean check(String prefix, char c, int[] cnt, String oddChar, String target) {
        StringBuilder left = new StringBuilder(prefix);
        left.append(c);
        for (int i = 25; i >= 0; i--) {
            for (int k = 0; k < cnt[i]; k++) {
                left.append((char)('a' + i));
            }
        }

        String palindrome = left.toString() + oddChar + new StringBuilder(left).reverse().toString();

        return palindrome.compareTo(target) > 0;
    }
}
