import java.util.ArrayList;
import java.util.List;

public class num118 {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ans = new ArrayList<>();
//        int[][] arr = new int[numRows][numRows];
//        for(int i=0;i<numRows;i++){
//            List<Integer> temp = new ArrayList<>();
//            for(int j=0;j<=i;j++){
//                if(j==0||j==i){
//                    arr[i][j] = 1;
//                }else {
//                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
//                }
//                temp.add(arr[i][j]);
//            }
//            ans.add(temp);
//        }
//        return ans;
//    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
