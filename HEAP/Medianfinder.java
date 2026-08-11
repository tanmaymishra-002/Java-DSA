import java.util.*;
public class Medianfinder {
    static class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }
        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }
            if (left.size() < right.size()) {
                left.add(right.poll());
            }
        }
        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            }
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
    }
}