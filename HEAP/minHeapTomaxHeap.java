import java.util.Arrays;
public class minHeapTomaxHeap {
    public static int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }
        return nums;
    }

    static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};
        System.out.println("Min Heap: " + Arrays.toString(nums));
        minToMaxHeap(nums);
        System.out.println("Max Heap: " + Arrays.toString(nums));
    }
}
