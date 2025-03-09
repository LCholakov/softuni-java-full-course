package Week1_Working_With_Abstraction.JediGalaxy_05;

public class Galaxy {
    private int[][] matrix;

    public Galaxy(int rows, int cols) {
        this.matrix = new int[rows][cols];
        this.populateMatrix();
    }

    private void populateMatrix() {
        int fillValue = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                this.matrix[i][j] = fillValue;
                fillValue++;
            }
        }
    }

    public void setEnemyValue(int row, int col) {
        this.matrix[row][col] = 0;
    }

    public int getCellValue(int row, int col) {
        return this.matrix[row][col];
    }

    public void moveEnemy(int row, int col) {
        while(row >= 0 && col >=0) {
            if(isInBounds(row,col)) {
                this.setEnemyValue(row, col);
            }
            row--;
            col--;
        }
    }

    public long movePlayer(int row, int col) {
        int collectedPower = 0;
        while(row >= 0 && col < this.matrix[0].length) {
            if(isInBounds(row, col)) {
                collectedPower += this.getCellValue(row, col);
            }
            row--;
            col++;
        }
        return collectedPower;
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < this.matrix.length
                && col >= 0 && col < this.matrix[row].length;
    }

}
