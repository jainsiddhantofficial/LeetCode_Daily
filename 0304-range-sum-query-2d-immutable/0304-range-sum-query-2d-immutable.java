class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length+1;
        int cols = matrix[0].length+1;
        prefixSum = new int[rows][cols];
        for(int i = 1; i<rows; i++) {
            for(int j = 1; j<cols; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // (row1, col1) --> (row2, col2)
        // since its easy to have 1 based prefixsum , so accordingly increased (row1++)
        row1++;
        row2++;
        col1++;
        col2++;
        return prefixSum[row2][col2] - prefixSum[row1-1][col2] - prefixSum[row2][col1-1] + prefixSum[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */