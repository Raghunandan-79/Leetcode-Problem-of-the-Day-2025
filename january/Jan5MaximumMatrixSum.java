package january;

import java.util.Scanner;

public class Jan5MaximumMatrixSum {
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            // size of the matrix
            int n = matrix.length;

            // variable to store max sum of matrix
            long totalSum = 0;

            // variable to store count of negative elements
            int negCount = 0;

            // variable to store minimum absolute value
            int minAbsValue = Integer.MAX_VALUE;

            // iterating the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // taking every element of matrix
                    int value = matrix[i][j];

                    // add absolute value of every element to matrix
                    totalSum += Math.abs(value);

                    // if element is less than 0
                    if (value < 0) {
                        // increase negative count
                        negCount++;
                    }

                    // if absolute value of every element is less than minimum absolute value then updating minimum absolute value
                    minAbsValue = Math.min(minAbsValue, Math.abs(value));
                }
            }

            /* 
                if negative count is even then returning total sum
                else returning total sum - 2 * minimum absolute value
            */
            return (negCount % 2 == 0) ? totalSum : totalSum - (2 * minAbsValue);
        }
    }
    
    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan5MaximumMatrixSum().new Solution();

        System.out.println(solution.maxMatrixSum(matrix));

        scanner.close();
    }
}