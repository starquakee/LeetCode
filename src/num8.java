import java.util.ArrayList;
import java.util.List;

public class num8 {
    public static int myAtoi(String s) {
        long l = 0;
        boolean is_neg = false;
        while (s.startsWith(" ")){
            s = s.substring(1);
        }
        if(s.startsWith("-")){
            s = s.substring(1);
            is_neg = true;
        } else if (s.startsWith("+")) {
            s = s.substring(1);
        }
        while (s.startsWith("0")){
            s = s.substring(1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(i>9&&s.charAt(i)-48>=0&&s.charAt(i)-48<=9){
                if(is_neg){
                    return -2147483648;
                }else {
                    return 2147483647;
                }
            }
            if(s.charAt(i)-48>=0&&s.charAt(i)-48<=9){
                list.add(s.charAt(i)-48);
            }else break;
        }
        for(int i=0;i<list.size();i++){
            l+=list.get(i)*Math.pow(10,list.size()-i-1);
        }
        int ans;
        if((l>2147483647L&& !is_neg) ||(l>2147483648L&&is_neg)){
            if(is_neg){
                ans = -2147483648;
            }else {
                ans = 2147483647;
            }
        }else ans = (int) l;
        if(is_neg) ans = -ans;
        return ans;
    }
    public static void main(String[] args) {
        char a = '-';
        System.out.println(a-48);
        System.out.println(myAtoi(" -1010023630o4"));

    }
}
