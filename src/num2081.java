public class num2081 {
    public long kMirror(int k, int n) {
        if(n==1)return 1L;
        long temp=1L;
        long ans=0L;
        ans+=temp;
        for(int i=1;i<n;){
            temp=findNextPalindrome(temp);
            System.out.println(temp);
            if(isKaryPalindrome(temp,k)){
                i++;
                ans+=temp;
            }
        }
        return ans;
    }
    public static long findNextPalindrome(long number) {
        String s = Long.toString(number);
        int len = s.length();
        String leftHalf = s.substring(0, (len + 1) / 2);

        // 1. 基于原始的左半部分构造一个候选回文数
        StringBuilder candidateBuilder = new StringBuilder(leftHalf);
        String partToReverse = leftHalf.substring(0, len / 2);
        candidateBuilder.append(new StringBuilder(partToReverse).reverse());

        long candidateNum = Long.parseLong(candidateBuilder.toString());

        // 2. 比较候选回文数与原始数
        if (candidateNum > number) {
            return candidateNum;
        } else {
            // 3. 如果候选数小于等于原始数，则需要将左半部分加1，再构造新回文数
            long newLeftNum = Long.parseLong(leftHalf) + 1;
            String newLeftStr = Long.toString(newLeftNum);

            // 检查前半部分加一后，长度是否增加 (例如 9 -> 10, 99 -> 100)
            if (newLeftStr.length() > leftHalf.length()) {
                // 如果长度增加，说明原数类似 9, 99, 999 这样的形式。
                // 新的回文数是 "1" + (原长度-1个"0") + "1"。
                StringBuilder finalPalindrome = new StringBuilder("1");
                for (int i = 0; i < len - 1; i++) {
                    finalPalindrome.append('0');
                }
                finalPalindrome.append('1');
                return Long.parseLong(finalPalindrome.toString());
            } else {
                // 如果长度没有增加，我们用新的前半部分构造回文数
                StringBuilder finalPalindrome = new StringBuilder(newLeftStr);
                String finalPartToReverse = newLeftStr.substring(0, len / 2);
                finalPalindrome.append(new StringBuilder(finalPartToReverse).reverse());
                return Long.parseLong(finalPalindrome.toString());
            }
        }
    }
    public static boolean isKaryPalindrome(long number, int k) {
        if (k < 2 || k > Character.MAX_RADIX) {
            throw new IllegalArgumentException("进制 k 必须在 2 和 " + Character.MAX_RADIX + " 之间。");
        }
        if (number < 0) {
            return false;
        }
        // 2. 将数字转换为 k 进制字符串
        String karyString = Long.toString(number, k);

        int left = 0;
        int right = karyString.length() - 1;
        while (left < right) {
            if (karyString.charAt(left) != karyString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
