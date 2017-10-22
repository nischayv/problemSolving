package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
    public class MaxHeapComparator implements Comparator<Integer> {
        // Comparator that sorts integers from highest to lowest
        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            if (o1 < o2) return 1;
            else if (o1 == o2) return 0;
            else return -1;
        }
    }

    public class MinHeapComparator implements Comparator<Integer>{
        // Comparator that sorts integers from lowest to highest
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) return 1;
            else if (o1 == o2)	return 0;
            else return -1;
        }
    }

    private static Comparator<Integer> maxHeapComparator;
    private static Comparator<Integer> minHeapComparator;
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void addNumber(int n) {
        // Make sure to maintain the maxheap size >= minHeap
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && n > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(n);
            } else {
                maxHeap.offer(n);
            }
        } else {
            if (n < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(n);
            } else {
                minHeap.offer(n);
            }
        }
    }

    public static double getMedian()  {
        if (maxHeap.isEmpty()) {
            return 0;
        }
        if (minHeap.size() != maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return ((double)minHeap.peek() + (double)maxHeap.peek())/2;
        }
    }


}
