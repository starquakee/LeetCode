public class num2124 {
    public boolean checkString(String s) {
        int i=0;
        while (i<s.length()&&s.charAt(i)=='a')i++;
        while (i<s.length()&&s.charAt(i)=='b')i++;
        return i==s.length();
    }
}
