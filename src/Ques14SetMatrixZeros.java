/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 考虑：这个题如果进行二维遍历，找到了之后对横竖都进行为0，那么就是O(n3)的时间复杂度。
 * Created by oubin on 17-3-24.
 */
public class Ques14SetMatrixZeros {

    public int[][] setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        // step 1，set edge elements as the label of an row or column.
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // step2:set zeros based on the labels.
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
