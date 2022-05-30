class Solution {
    // DFS Solution
    // Time complexity is O(mn)
    // Space complexity is O(mn))
    // This solution is submitted on leetcode with no errors
    private int rowLen;
    private int colLen;
    private int[][] dirs;
    public int numIslands(char[][] grid) {
        // Edge case
        if(grid == null || grid.length ==0) return -1;
        rowLen = grid.length;
        colLen = grid[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int count = 0;
        for(int i = 0;i<rowLen; i++){
            for(int j = 0 ;j<colLen; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i , int j){
        // base case
        if(i<0 || j<0 || i == rowLen || j == colLen || grid[i][j] != '1' || grid[i][j] == '2') return;
        // Logic
        grid[i][j] = '2';
        for(int[] dir:dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid,r, c);
        }
    }
}