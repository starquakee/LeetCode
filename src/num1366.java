import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num1366 {
    public String rankTeams(String[] votes) {
        int num = votes[0].length();
        int[][] arr = new int[26][num+1];
        for(int i=0;i<votes.length;i++){
            for(int j=1;j<=num;j++){
                int a = votes[i].charAt(j-1)-'A';
                arr[a][j]++;
                arr[a][0]=a;
            }
        }
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, arr);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int count=1;
                while (count<o1.length&&o1[count]==o2[count]){
                    count++;
                }
                if(count==o1.length)return o1[0]-o2[0];
                return o2[count]-o1[count];
            }
        });
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<num;i++){
//            System.out.println(list.get(i)[0]);
            ans.append((char) (list.get(i)[0] + 'A'));
        }
        return ans.toString();
    }
}
