import java.util.HashMap;
import java.util.Map;

public class num2131 {
    public int longestPalindrome(String[] words) {
        int ans=0;
        boolean mid=false;
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String key:map.keySet()){
            if(key.charAt(0)!=key.charAt(1)){
                String s = ""+key.charAt(1)+key.charAt(0);
                int num=Math.min(map.getOrDefault(key,0),map.getOrDefault(s,0));
                if(num>0){
                    ans+=4*num;
                    map.put(key,map.getOrDefault(key,0)-num);
                    map.put(s,map.getOrDefault(s,0)-num);
                }
            }else {
                ans+=(map.getOrDefault(key,0)/2)*4;
                map.put(key,map.getOrDefault(key,0)%2);
                if(map.getOrDefault(key,0)==1){
                    mid=true;
                }
            }
        }
        if(mid)ans+=2;
        return ans;
    }
}
