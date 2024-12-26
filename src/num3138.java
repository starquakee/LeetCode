import java.util.*;

public class num3138 {
    public int minAnagramLength(String s) {
        int n = s.length();
        for(int i=1;i<n;i++){
            if(n%i==0){
                if(check(s,i))return i;
            }
        }
        return s.length();
    }
    public boolean check(String s, Integer gcd){
        int[] freq = new int[26];
        for(int i=0;i<gcd;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=1;i<=s.length()/gcd-1;i++){
            int[] temp = new int[26];
            for(int j=i*gcd;j<i*gcd+gcd;j++){
                temp[s.charAt(j)-'a']++;
            }
            if(!Arrays.equals(freq,temp))return false;
        }
        return true;
    }
}
