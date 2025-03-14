public class num3340 {
    public boolean isBalanced(String num) {
        int odd=0,even=0;
        for(int i=0;i<num.length();i+=2){
            odd+=num.charAt(i)-'0';
        }
        for(int i=1;i<num.length();i+=2){
            even+=num.charAt(i)-'0';
        }
        return odd==even;
    }
}
