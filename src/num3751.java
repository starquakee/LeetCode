public class num3751 {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++) {
            count+=countWaviness(i);
        }
        return count;
    }
    public int countWaviness(int num) {
        int count=0;
        String s=String.valueOf(num);
        for(int i=1;i<s.length()-1;i++) {
            if((s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)) || (s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1))) {
                count++;
            }
        }
        return count;
    }
}
