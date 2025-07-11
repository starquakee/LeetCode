import java.util.*;

public class num56 {
//    public static int[][] merge(int[][] intervals) {
//        Set<int[]> list = new HashSet<>();
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> same = new HashSet<>();
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });
//        for(int i=0;i<intervals.length;i++){
//            if(intervals[i][0]<intervals[i][1]){
//                for(int j=intervals[i][0];j<intervals[i][1];j++){
//                    set.add(j);
//                }
//            }
//        }
//        for(int i=0;i<intervals.length;i++){
//            if(intervals[i][0]==intervals[i][1]&&!set.contains(intervals[i][0])&&!set.contains(intervals[i][0]-1)){
//                if(!same.contains(intervals[i][0])){
//                    list.add(new int[]{intervals[i][0], intervals[i][0]});
//                    same.add(intervals[i][0]);
//                }
//            }
//        }
//        List<Integer> sortedList = new ArrayList<>(set);
//        Collections.sort(sortedList);
//        System.out.println(sortedList);
//        if(sortedList.size()>0){
//            int min=sortedList.get(0);
//            int max=sortedList.get(0);
//            for(int i=1;i<sortedList.size();i++){
//                if(sortedList.get(i)-sortedList.get(i-1)==1){
//                    max=sortedList.get(i);
//                    if(i==sortedList.size()-1){
//                        list.add(new int[]{min,max+1});
//                    }
//                }else {
//                    list.add(new int[]{min,max+1});
//                    min=sortedList.get(i);
//                    max=sortedList.get(i);
//                    if(i==sortedList.size()-1){
//                        list.add(new int[]{min,min+1});
//                    }
//                }
//            }
//            if(sortedList.size()==1){
//                list.add(new int[]{sortedList.get(0),sortedList.get(0)+1});
//            }
//        }
//
//        int[][] array = new int[list.size()][];
//        int i=0;
//        for(int[] s:list){
//            array[i]=s;
//            i++;
//        }
//        return array;
//    }


//    public int[][] merge(int[][] intervals) {
//        if (intervals.length == 0) {
//            return new int[0][2];
//        }
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//        List<int[]> merged = new ArrayList<>();
//        for (int i = 0; i < intervals.length; ++i) {
//            int L = intervals[i][0], R = intervals[i][1];
//            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                merged.add(new int[]{L, R});
//            } else {
//                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparing(a->a[0]));
        List<int[]> ans=new ArrayList<>();
        int l=0;
        int r=-1;
        for(int[] interval:intervals){
            if(interval[0]>r){
                if(r>=0) ans.add(new int[]{l,r});
                l=interval[0];
                r=interval[1];
            }else{
                r=Math.max(r,interval[1]);
            }
        }
        ans.add(new int[]{l,r});
        return ans.toArray(new int[ans.size()][]);
    }
}
