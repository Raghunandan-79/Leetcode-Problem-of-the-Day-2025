package january;

import java.util.Scanner;

public class Jan1PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            
            // iterating from back of the array
            for (int i = n - 1; i >= 0; i--) {
                // adding 1 to the value of element at that index
                digits[i]++;

                // if element at that index becomes equal to 10 then update element at that index to be 0
                if (digits[i] == 10) digits[i] = 0;
                else return digits; // else return digits
            }

            digits = new int[n + 1]; // increase size of array by 1
            digits[0] = 1; // update value at 0th index with 1

            // return the digits array
            return digits;
        }
    }


    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }

        Solution solution = new Jan1PlusOne().new Solution();
        for (int num : solution.plusOne(digits)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
