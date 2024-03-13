public class num2864 {
    public String maximumOddBinaryNumber(String s) {
        int num1 = 0;
        int n = s.length();
        for(char c:s.toCharArray()){
            if(c=='1')num1++;
        }
        String ans = "";
        for(int i=0;i<num1-1;i++){
            ans += "1";
        }
        for(int i=num1-1;i<n-1;i++){
            ans += "0";
        }
        ans += "1";
        return ans;
    }
}
