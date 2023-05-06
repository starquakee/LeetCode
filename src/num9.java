public class num9 {
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int len=1;
        while (x/len>=10){
            len*=10;
        }
        while (x>0){
            if(x/len!=x%10){
                return false;
            }
            x = x%len/10;
            len/=100;
            System.out.println(x);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println( isPalindrome(1000021));

    }
}
