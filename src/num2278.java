public class num2278 {
    public int percentageLetter(String s, char letter) {
        int cnt=0;
        for(char c:s.toCharArray()){
            if(c==letter)cnt++;
        }
        return 100*cnt/s.length();
    }
}
