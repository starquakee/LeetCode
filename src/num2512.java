import java.util.*;

public class num2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }
        for (String word : negative_feedback) {
            words.put(word, -1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });
        for(int i=0;i<student_id.length;i++){
            int id = student_id[i];
            int score = 0;
            for(String s:report[i].split(" ")){
                score += words.getOrDefault(s,0);
            }
            priorityQueue.offer(new int[]{score,id});
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            int ans = priorityQueue.poll()[1];
            list.add(ans);
        }
        return list;
    }
}
