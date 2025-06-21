import java.util.Arrays;

public class num3085 {
    public int minimumDeletions(String word, int k) {
        int ans=0;
        int[] freq = new int[26];
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int minFreq=0;
        int minIndex=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;
            minFreq=freq[i];
            minIndex=i;
            break;
        }
        int temp=0;
        for(int i=0;i<26;i++){
            temp+=Math.max(0,freq[i]-k-minFreq);
        }
        ans=temp;
        for(int i=minIndex;i<25;i++){
            temp=0;
            for(int j=minIndex;j<=i;j++){
                temp+=freq[j];
            }
            minFreq=freq[i+1];
            for(int ii=i+1;ii<26;ii++){
                temp+=Math.max(0,freq[ii]-k-minFreq);
            }
            ans=Math.min(ans,temp);
        }
        return ans;
    }
}
