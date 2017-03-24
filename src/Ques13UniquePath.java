/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of
 * the grid (marked 'Finish' in the diagram below).
 * 考虑：使用动态规划算法。每一步的结果都记录下来，然后每一步的结果是左边和上边的值的和。
 * Created by oubin on 17-3-24.
 */
public class Ques13UniquePath {

    /**
     * 问题一：没有障碍的情况
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dis[i][j]=1;
                }
                else{
                    dis[i][j]=dis[i-1][j]+dis[i][j-1];
                }
            }
        }
        return dis[m-1][n-1];
    }

    /**
     * 此题会给出一个二维数组，其中为0或者1，为1的是障碍。
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dis = new int[m][n];
        boolean block = false;
        for (int i = 0; i < m; i++){
            if (dis[i][0] == 1) block = true;
            if (!block){
                dis[i][0] = 1;
            }else{
                dis[i][0] = 0;
            }
        }
        block = false;
        for (int i = 0; i < n; i++){
            if (dis[0][i] == 1) block = true;
            if (!block){
                dis[0][i] = 1;
            }else{
                dis[0][i] = 0;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    dis[i][j]=0;
                }
                else{
                    dis[i][j]=dis[i-1][j]+dis[i][j-1];
                }
            }
        }
        return dis[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
