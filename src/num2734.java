public class num2734 {
    public String smallestString(String s) {
        int n = s.length();
        StringBuilder ss = new StringBuilder();
        for(int i=0;i<n;i++){
            ss.append("a");
        }
        if(s.contentEquals(ss)){
            return ss.deleteCharAt(n-1).append("z").toString();
        }
        int left = 0;
        int right = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='a'){
                left = i;
                while (i<n&&s.charAt(i)!='a'){
                    i++;
                }
                right = i-1;
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i>=left&&i<=right){
                ans.append((char)(s.charAt(i)-1));
            }else ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
