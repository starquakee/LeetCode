public class num240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix){
            if(search(row,target)){
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] row, int num){
        int n = row.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(row[mid]==num){
                return true;
            }else {
                if(row[mid]<num){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
