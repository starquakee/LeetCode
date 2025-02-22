public class num2506 {
    public int similarPairs(String[] words) {
        String[] ans = new String[words.length];
        int res=0;
        for(int i=0;i< words.length;i++){
            for(char j='a';j<='z';j++){
                String s = String.valueOf(j);
                if(words[i].contains(s))ans[i]+=s;
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j< words.length;j++){
                if(ans[i].equals(ans[j]))res++;
            }
        }
        return res;
    }
}
