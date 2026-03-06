public class num1784 {
    public boolean checkOnesSegment(String s) {
        int i=0;
        int count=0;
        while (i<s.length()) {
            while (i<s.length()&&s.charAt(i)=='1')i++;
            count++;
            while (i<s.length()&&s.charAt(i)=='0')i++;
        }
        return count<2;
    }
}
