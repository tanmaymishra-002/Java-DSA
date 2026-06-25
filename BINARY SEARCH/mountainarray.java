
public class mountainarray {

    public static void main(String[] args) {

        int[] arr = {0, 2, 5, 7, 6, 4, 1};

        int peak = peakIndexInMountainArray(arr);

        System.out.println("Peak index: " + peak);
        System.out.println("Peak element: " + arr[peak]);
    }

    // Finds the index of the peak element
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // You are in the descending part
                end = mid;
            } else {
                // You are in the ascending part
                start = mid + 1;
            }
        }

        return start; // or return end
    }
}