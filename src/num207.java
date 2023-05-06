import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, HashSet<Object>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new HashSet<>());

        }
        for(int i=0;i< prerequisites.length;i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean b=true;
        while (b){
            b=false;
            for(int i=0;i<numCourses;i++){
                if(map.get(i).isEmpty()){
                    boolean bb=false;
                    for(int ii=0;ii<numCourses;ii++){

                        if(map.get(ii).contains(i)){
                            bb=true;
                        }
                        map.get(ii).remove(i);
                        if(map.get(ii).isEmpty()&&!b)b= bb;
                    }
                }
            }
        }

        for(int i = 0;i<numCourses;i++){
            if(!map.get(i).isEmpty()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.isEmpty());
    }
}
