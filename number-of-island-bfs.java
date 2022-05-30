import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(mn)
    // Space complexity is O(min(m,n))
    // This solution is submitted on leetcode with no errors
    public int numIslands(char[][] grid) {
        // Edge case
        if(grid == null || grid[0].length == 0) return -1;
        
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0;i<rowLen;i++){
            for(int j = 0; j<colLen;j++){
                if(grid[i][j] == '1'){ 
                    grid[i][j] = '2';
                    count++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        for(int[] dir: dirs){
                            int r = dir[0] + temp[0];
                            int c = dir[1] + temp[1];
                            if(r>=0 && c>=0 && r< rowLen && c<colLen && grid[r][c] == '1'){
                                q.add(new int[]{r,c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}