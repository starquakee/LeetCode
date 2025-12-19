import java.util.*;

public class num2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> arr = new ArrayList<>();
        for (int[] meeting : meetings) {
            arr.add(new int[]{meeting[0], meeting[1], meeting[2]});
        }
        boolean[] isKnown = new boolean[n];
        isKnown[0] = true;
        isKnown[firstPerson] = true;
        arr.sort((a, b) -> a[2] - b[2]);
        int i=0;
        int j=0;
        while(i<arr.size()){
            j=i;
            while (j+1<arr.size()&&arr.get(j)[2]==arr.get(j+1)[2]){
                j+=1;
            }
            Set<Integer> vertices = new HashSet<>();
            Map<Integer, List<Integer>> edges = new HashMap<>();
            for(int k=i;k<=j;k++){
                vertices.add(arr.get(k)[0]);
                vertices.add(arr.get(k)[1]);
                edges.computeIfAbsent(arr.get(k)[0], key -> new ArrayList<>()).add(arr.get(k)[1]);
                edges.computeIfAbsent(arr.get(k)[1], key -> new ArrayList<>()).add(arr.get(k)[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for(int vertex:vertices){
                if(isKnown[vertex]){
                    queue.offer(vertex);
                }
            }
            while (!queue.isEmpty()){
                int node = queue.poll();
                if(edges.containsKey(node)){
                    for(int friend:edges.get(node)){
                        if(!isKnown[friend]){
                            queue.offer(friend);
                            isKnown[friend]=true;
                        }
                    }
                }
            }
            i=j+1;
        }
        for(int ii=0;ii<n;ii++){
            if(isKnown[ii]){
                ans.add(ii);
            }
        }
        return ans;
    }
}
