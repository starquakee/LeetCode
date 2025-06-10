public class num3442 {
    public int maxDifference(String s) {
        int max=0;
        int min=999999;
        int[] cnt=new int[26];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(cnt[i]%2==0&&cnt[i]>0){
                min=Math.min(min,cnt[i]);
            }else max=Math.max(max,cnt[i]);
        }
        return max-min;
    }
}
