import java.util.Arrays;

public class num2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m=players.length;
        int n=trainers.length;
        int ans=0;
        int index1=0,index2=0;
        while (index1<m&&index2<n){
            while (index2<n&&players[index1]>trainers[index2]){
                index2++;
            }
            if(index2==n)return ans;
            ans++;
            index1++;
            index2++;
        }
        return ans;
    }
}
