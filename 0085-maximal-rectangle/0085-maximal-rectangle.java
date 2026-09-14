import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pref = new int[n][m];
        pref = comp(matrix);
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            int ans = largestRectangleArea(pref[i]);
            max = Math.max(max, ans);
       }
        return max;
    }
    public int[][] comp(char[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Convert char to int
                int val = arr[i][j] - '0';
                if (i == 0)
                    ans[0][j] = val;
                else
                {
                    if (val == 1)
                        ans[i][j] = ans[i - 1][j] + 1;
                    else
                        ans[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) 
    {
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];
        // nsr
        Stack<Integer> s = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--)
        {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i])
                s.pop();

            if (s.isEmpty())
                nsr[i] = heights.length;
            else
                nsr[i] = s.peek();

            s.push(i);
        }
        // nsl
        s = new Stack<>();
        for (int i = 0; i < heights.length; i++)
        {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i])
                s.pop();
            if (s.isEmpty())
                nsl[i] = -1;
            else
                nsl[i] = s.peek();
            s.push(i);
        }
        // area calc
        for (int i = 0; i < heights.length; i++)
        {
            int width = nsr[i] - nsl[i] - 1;
            int height = heights[i];
            int currArea = width * height;
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}