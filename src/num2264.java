public class num2264 {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i=9;i>=0;i--){
            String temp = i +String.valueOf(i)+ i;
            if(num.contains(temp))return temp;
        }
        return ans;
    }
}
