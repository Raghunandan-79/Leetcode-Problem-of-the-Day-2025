package january;

import java.util.Scanner;

public class Jan3NumberOfWaysToPaintNx3Grid {
    class Solution {
        public int numOfWays(int n) {
            final int MOD = 1_000_000_007;

            // A: number of ways to paint row i with different color than row i-1
            long A = 6;
            // B: number of ways to paint row i with same pattern as row i-1
            long B = 6;

            // Dynamic programming: calculate ways for each subsequent row
            for (int i = 2; i <= n; i++) {
                // New A depends on previous A and B states
                long newA = (2 * A + 2 * B) % MOD;
                
                // New B depends on previous A and B states
                long newB = (2 * A + 3 * B) % MOD;
                
                A = newA;
                B = newB;
            }

            // Return total ways (sum of both states) modulo MOD
            return (int) ((A + B) % MOD);
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Jan3NumberOfWaysToPaintNx3Grid().new Solution();

        System.out.println(solution.numOfWays(n));

        scanner.close();
    }
}
