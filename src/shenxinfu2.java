import java.math.BigInteger;

public class shenxinfu2 {
    public static void main(String[] args) {
        String inputNumber = "3952238297325822439872323928427"; // 输入一个很大的正整数，以字符串形式表示

        // 将输入的字符串转换为BigInteger
        BigInteger number = new BigInteger(inputNumber);
        BigInteger maxNumber = number; // 保存最大值

        int numDigits = inputNumber.length(); // 计算数字的位数

        for (int i = 0; i < numDigits; i++) {
            // 循环右移一位
            BigInteger lastDigit = number.remainder(BigInteger.TEN);
            number = lastDigit.multiply(BigInteger.TEN.pow(numDigits - 1)).add(number.divide(BigInteger.TEN));

            // 更新最大值
            if (number.compareTo(maxNumber) > 0) {
                maxNumber = number;
            }
        }
        // 输出最大值
        System.out.println("通过循环右移操作能达到的最大值为：" + maxNumber);
    }
}
