public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        size++;
        int currentIndex = size - 1;
        heap[currentIndex] = value;

        // 向上调整堆
        while (currentIndex > 0 && heap[currentIndex] < heap[parentIndex(currentIndex)]) {
            swap(currentIndex, parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }

    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // 向下调整堆
        int currentIndex = 0;
        while (true) {
            int leftChild = leftChildIndex(currentIndex);
            int rightChild = rightChildIndex(currentIndex);
            int smallest = currentIndex;

            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (smallest == currentIndex) {
                break;
            }

            swap(currentIndex, smallest);
            currentIndex = smallest;
        }

        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(2);

        System.out.println("Min Heap Size: " + minHeap.size);
        System.out.println("Min Element: " + minHeap.getMin());

        int min = minHeap.extractMin();
        System.out.println("Extracted Min Element: " + min);
        System.out.println("Min Heap Size after Extraction: " + minHeap.size);
    }
}
