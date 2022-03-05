package heap;

import java.util.PriorityQueue;

/*
You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Input: sticks = [2,4,3]
Output: 14
Explanation: You start with sticks = [2,4,3].
1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
 */
public class ConnectSticks {
    public int connectSticks(int[] sticks) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : sticks)
            heap.offer(i);
        //System.out.println("heap " + heap);
        int sum=0;
        while(heap.size()!=1)
        {
            //if(heap.size()>=2) {
                int no1 = heap.poll();
                int no2 = heap.poll();
                sum = sum + no1 + no2;
                heap.offer(no1+no2);
            //}

            //if(heap.size()==1) break;

        }
        System.out.println(sum);
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int[] sticks = new int[] {1,8,3,5};
        System.out.println("final " + new ConnectSticks().connectSticks(sticks));
    }
}
