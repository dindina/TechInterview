package heap;

import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1);
        for(int num : stones)
        {
            maxHeap.offer(num);
        }
        System.out.println("initial heap " + maxHeap);
        while(maxHeap.size() >1)
        {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x > y) {
                int x1 = x -y;
                maxHeap.offer(x1);
            }
            else if( y>x)
            {
                int y1 = y-x;
                maxHeap.offer(y1);
            }
            System.out.println("after x=" +x + " y=" +y + "heap " + maxHeap);
        }
        System.out.println(maxHeap);
        if(maxHeap.size() >0)
        return maxHeap.peek();
        else return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1};
        System.out.println(new LastStoneWeight().lastStoneWeight(nums));
    }
}
