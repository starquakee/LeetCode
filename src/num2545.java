import java.util.*;

class StudentScores implements Comparable<StudentScores>{
    int[] scores;
    int k;
    public StudentScores(int[] scores, int k){
        this.scores = scores;
        this.k = k;
    }

    @Override
    public int compareTo(StudentScores scores1) {
        return scores1.scores[k]-this.scores[k];
    }
}
public class num2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        List<StudentScores> list = new ArrayList<>();
        for(int[] s:score){
            list.add(new StudentScores(s,k));
        }
        Collections.sort(list);
        int[][] ans = new int[score.length][score[0].length];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i).scores;
        }
        return ans;
    }
    // OR
//    public int[][] sortTheStudents(int[][] score, int k) {
//        Arrays.sort(score, (o1, o2) -> o2[k]-o1[k]);
//        return score;
//    }
}
