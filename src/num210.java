import java.util.*;

public class num210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());

        }
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];
        int place = 0;
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
            ans[place++] = num;
            for(int child:map.get(num)){
                in[child]--;
                if(in[child]==0){
                    queue.offer(child);
                }
            }
        }
        if(cnt!=numCourses)return new int[1];
        return ans;
    }
}
