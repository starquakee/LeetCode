import java.util.*;
import java.util.stream.Collectors;

public class num215 {
//    public int findKthLargest(int[] nums, int k) {
//        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//        priorityQueue.addAll(collect);
//        for(int i=0;i<k-1;i++){
//            priorityQueue.poll();
//        }
//        return priorityQueue.poll();
//    }
    public int findKthLargest(int[] arr, int k) {
        int targetIndex = arr.length - k;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == targetIndex) {
                return arr[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }
        return -1;
    }
    public int partition(int[] arr, int low, int high) {
        int l = low;
        int pivot = arr[high];
        for (int i = low; i <= high; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, l);
                l++;
            }
        }
        return l - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
