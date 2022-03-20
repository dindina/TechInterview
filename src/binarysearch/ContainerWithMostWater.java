package binarysearch ;
/*
ou are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1

 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;

        int maxarea = 0;

        while(left < right)
        {
            //calculate area between left and right
            int area = Math.min(height[left],height[right])*(right-left);
            maxarea = Math.max(area,maxarea);
            // how to increment the pointer ?

            if(height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxarea;

    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,68,2,5,4,60,3,6};
        System.out.println(new ContainerWithMostWater().maxArea(nums));

    }
}
