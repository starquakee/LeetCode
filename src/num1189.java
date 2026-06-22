public class num1189 {
    public int maxNumberOfBalloons(String text) {
        int ans=99999;
        int[] cnt=new int[5];
        for(char c:text.toCharArray()) {
            switch (c) {
                case 'b':
                    cnt[0]++;
                    break;
                case 'a':
                    cnt[1]++;
                    break;
                case 'l':
                    cnt[2]++;
                    break;
                case 'o':
                    cnt[3]++;
                    break;
                case 'n':
                    cnt[4]++;
                    break;
            }
        }
        ans=Math.min(ans,cnt[0]);
        ans=Math.min(ans,cnt[1]);
        ans=Math.min(ans,cnt[2]/2);
        ans=Math.min(ans,cnt[3]/2);
        ans=Math.min(ans,cnt[4]);
        return ans;
    }
}
