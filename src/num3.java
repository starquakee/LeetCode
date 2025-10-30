import java.util.HashMap;
import java.util.Map;

public class num3 {
//    public static int lengthOfLongestSubstring(String s) {
//        int ans = 0;
//        int temp = 0;
//        int start=0;
//        int end=0;
//        for(int i=0;i<s.length();i++){
//            String str = s.substring(start,end);
//            System.out.println(str+"  "+s.charAt(i));
//            if(!str.contains(s.substring(i,i+1))){
//                temp += 1;
//                end += 1;
//                ans = Math.max(ans, temp);
//            }else {
//                start += 1+str.indexOf(s.substring(i,i+1));
//                end += 1;
//                temp = end - start;
//            }
//        }
//        return ans;
//    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())return 0;
        Map<Character,Integer> map = new HashMap<>();
        int ans=1;
        map.put(s.charAt(0),1);
        int left=0;
        int right=1;
        while (right<s.length()&&left<=right){
            if(map.getOrDefault(s.charAt(right),0)>0){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                left++;
            }else {
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
                ans=Math.max(ans,right-left+1);
                right++;
            }
        }
        return ans;
    }
}
