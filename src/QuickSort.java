import java.util.LinkedList;
import java.util.List;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if(low<high){
            int pivotIndex = partition(array,low,high);
            quickSort(array,low,pivotIndex-1);
            quickSort(array,pivotIndex+1,high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int i=low-1;
        int pivot = array[high];
        for(int j=low;j<=high;j++){
            if(array[j]<=pivot){
                i++;
                swap(array,i,j);
            }
        }
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        int n = array.length;

        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        quickSort(array, 0, n - 1);

        System.out.println("\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
