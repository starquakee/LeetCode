public class num3 {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int temp = 0;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            String str = s.substring(start,end);
            System.out.println(str+"  "+s.charAt(i));
            if(!str.contains(s.substring(i,i+1))){
                temp += 1;
                end += 1;
                ans = Math.max(ans, temp);
            }else {
                start += 1+str.indexOf(s.substring(i,i+1));
                end += 1;
                temp = end - start;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
