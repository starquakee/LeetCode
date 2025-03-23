public class num2116 {
    //采用从左往右和从右往左遍历的贪心算法，分别保证前缀合法，后缀合法。
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0) return false; // 奇数长度不可能平衡

        int balance = 0;
        // 从左到右扫描，假设所有未锁定位置都能变为 '('
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                balance++;
            } else { // locked且为 ')'
                balance--;
            }
            if (balance < 0) return false;
        }

        balance = 0;
        // 从右到左扫描，假设所有未锁定位置都能变为 ')'
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                balance++;
            } else { // locked且为 '('
                balance--;
            }
            if (balance < 0) return false;
        }
        return true;
    }
}
