import java.util.*;

public class num207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());

        }
        int[] in = new int[numCourses];
        for(int i=0;i< prerequisites.length;i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            cnt++;
            for(int child:map.get(num)){
                in[child]--;
                if(in[child]==0){
                    queue.offer(child);
                }
            }
        }
        return cnt==numCourses;
    }
}
