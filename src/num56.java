import java.util.*;

public class num56 {
    public static int[][] merge(int[][] intervals) {
        Set<int[]> list = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> same = new HashSet<>();
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i][1]){
                for(int j=intervals[i][0];j<intervals[i][1];j++){
                    set.add(j);
                }
            }
        }
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]==intervals[i][1]&&!set.contains(intervals[i][0])&&!set.contains(intervals[i][0]-1)){
                if(!same.contains(intervals[i][0])){
                    list.add(new int[]{intervals[i][0], intervals[i][0]});
                    same.add(intervals[i][0]);
                }
            }
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        System.out.println(sortedList);
        if(sortedList.size()>0){
            int min=sortedList.get(0);
            int max=sortedList.get(0);
            for(int i=1;i<sortedList.size();i++){
                if(sortedList.get(i)-sortedList.get(i-1)==1){
                    max=sortedList.get(i);
                    if(i==sortedList.size()-1){
                        list.add(new int[]{min,max+1});
                    }
                }else {
                    list.add(new int[]{min,max+1});
                    min=sortedList.get(i);
                    max=sortedList.get(i);
                    if(i==sortedList.size()-1){
                        list.add(new int[]{min,min+1});
                    }
                }
            }
            if(sortedList.size()==1){
                list.add(new int[]{sortedList.get(0),sortedList.get(0)+1});
            }
        }

        int[][] array = new int[list.size()][];
        int i=0;
        for(int[] s:list){
            array[i]=s;
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,4},{5,6}};
        System.out.println(Arrays.deepToString(merge(ints)));
    }
}
