public class QuickSortNew {
    public int[] quickSort(int[] arr,int low,int high){
        if(low<high){
            int pivotIndex=partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
        return arr;
    }
    public int partition(int[] arr,int low,int high){
        int l=low;
        int pivot=arr[high];
        for(int i=low;i<=high;i++){
            if(arr[i]<=pivot){
                swap(arr,i,l);
                l++;
            }
        }
        return l-1;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        QuickSortNew quickSortNew = new QuickSortNew();
        quickSortNew.quickSort(arr,0,arr.length-1);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
