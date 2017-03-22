/**
 * 二维数组n*n的旋转,顺时针旋转90度。要求原地旋转
 * 考虑：有两种翻折方法比较好，1.A[i][j] = A[j][n - 1 - i]   2.先按副对角线翻折，再按水平 中线翻折。
 * Created by oubin on 17-3-22.
 */
public class Ques8RotateImage {

    public static void rotateImage(int[][] matrix){
        if (matrix == null || matrix.length == 0) return;

        int temp;
        int n = matrix.length;
        // 沿着副对角线翻折
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

        // 沿着水平中线翻折
        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }

}
