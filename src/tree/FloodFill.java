package tree;
/*
https://leetcode.com/problems/flood-fill/
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        dfs_floodfill(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private void dfs_floodfill(int[][] image, int sr, int sc, int newColor, int origcolor) {

        int imagerow = image.length;
        int imagecol = image[0].length;

        if(sr <0 || sr >= imagerow || sc < 0 || sc >= imagecol || image[sr][sc]== newColor || image[sr][sc] != origcolor )
            return;
        image[sr][sc] = newColor;

        dfs_floodfill(image,sr+1,sc,newColor,origcolor );
        dfs_floodfill(image,sr-1,sc,newColor ,origcolor);
        dfs_floodfill(image,sr,sc+1,newColor ,origcolor);
        dfs_floodfill(image,sr,sc-1,newColor ,origcolor);

    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1,1,1},{1,1,0},{1,0,1}
        };

        int [][] newimage =  new FloodFill().floodFill(image,1,1,2);
        System.out.println("completed");

    }
}
