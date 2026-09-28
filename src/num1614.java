public class num1614 {
    public int maxDepth(String s) {
        int ans=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                ans++;
                res=Math.max(res,ans);
            }
            else if (s.charAt(i)==')') {
                ans--;
            }
        }
        return res;
    }
}
