public class num2520 {
    public int countDigits(int num) {
        String s = String.valueOf(num);
        int ans = 0;
        for(char c:s.toCharArray()){
            if(num%(c-'0')==0)ans++;
        }
        return ans;
    }
}
