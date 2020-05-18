package com.zhengxl.backtracking;

/**
 * @description:八皇后问题
 * @projectName:algorithm
 * @see:com.zhengxl.backtracking
 * @author:郑晓龙
 * @createTime:2020/5/11 10:07
 * @version:1.0
 */
public class EightQueen {
    private int count = 0;

    private int[] result = new int[8];

    public EightQueen() {
        callEightQueens(0);
    }

    public void callEightQueens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                callEightQueens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int rowNumber = row - 1; rowNumber >= 0; rowNumber--) {
            if (result[rowNumber] == column) {
                return false;
            }
            if (leftUp >= 0 && result[rowNumber] == leftUp) {
                return false;
            }
            if (rightUp <= 8 && result[rowNumber] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void printQueens(int[] result) {
        count++;
        System.out.println("--------"+count+"-----------");
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }


}
