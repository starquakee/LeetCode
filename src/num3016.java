import java.util.Arrays;

public class num3016 {
    public int minimumPushes(String word) {
        Integer[] arr = new Integer[26];
        for(int i=0;i<26;i++){
            arr[i]=0;
        }
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        Arrays.sort(arr, (a, b) -> b - a);
        int ans=0;
        for(int i=0;i<26;i++){
            if(arr[i]==null)break;
            if(i<8){
                ans+=arr[i];
            }else if(i<16){
                ans+=arr[i]*2;
            }else if(i<24){
                ans+=arr[i]*3;
            }else {
                ans += arr[i] * 4;
            }
        }
        return ans;
    }
}
