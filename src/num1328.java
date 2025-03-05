public class num1328 {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length();
        if(n==1)return "";
        int half=n/2;
        String ans;
        for(int i=0;i<half;i++){
            if(palindrome.charAt(i)>'a'){
                ans=palindrome.substring(0,i)+"a"+palindrome.substring(i+1);
                return ans;
            }
        }
        return palindrome.substring(0,n-1)+"b";
    }
}
