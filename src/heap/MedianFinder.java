package heap;

import java.util.PriorityQueue;


/*The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

        For example, for arr = [2,3,4], the median is 3.
        For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
        Implement the MedianFinder class:

        MedianFinder() initializes the MedianFinder object.
        void addNum(int num) adds the integer num from the data stream to the data structure.
        double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


        Example 1:

        Input
        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        [[], [1], [2], [], [3], []]
        Output
        [null, null, null, 1.5, null, 2.0]

        Explanation
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
*/
public class MedianFinder {

    PriorityQueue<Integer> min = null;
    PriorityQueue<Integer> max = null;

    public MedianFinder() {
        min = new PriorityQueue<>((n1,n2)->n1-n2);
        max = new PriorityQueue<>((n1,n2)->n2-n1); // revers orderr
    }

    public void addNum(int num) {

        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size())// balancing
            max.offer(min.poll());

    }

    public double findMedian() {
       if(max.size()==0) return 0;
        if(max.size() > min.size())
            return max.peek();
        else {
            System.out.println("max peek" + max.peek());
            System.out.println("min peek" + min.peek());
            return (double)(max.peek() + min.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        //medianFinder.addNum(3);
        //System.out.println(medianFinder.findMedian());
    }
}
