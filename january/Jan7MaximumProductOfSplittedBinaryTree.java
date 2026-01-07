package january;

public class Jan7MaximumProductOfSplittedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        
        TreeNode(int val) { 
            this.val = val; 
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        long total = 0, best = 0;
        static final int MOD = 1_000_000_007;

        // Calculate the total sum of all node values in the tree
        long sum(TreeNode node) {
            if (node == null) return 0;
            return node.val + sum(node.left) + sum(node.right);
        }

        // DFS to find the maximum product by trying each subtree as a split point
        long dfs(TreeNode node) {
            if (node == null) return 0;
            // Calculate sum of current subtree
            long s = node.val + dfs(node.left) + dfs(node.right);
            // Update best product: left part * right part when cutting at this node
            best = Math.max(best, s * (total - s));
            return s;
        }

        // Main method to return maximum product modulo 10^9+7
        public int maxProduct(TreeNode root) {
            total = sum(root);  // Get total sum of tree
            dfs(root);          // Find best split point
            return (int) (best % MOD);
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Jan7MaximumProductOfSplittedBinaryTree solution = new Jan7MaximumProductOfSplittedBinaryTree();
        Jan7MaximumProductOfSplittedBinaryTree.Solution solver = solution.new Solution();

        // Example: tree [1,2,3,4,5,6]
        TreeNode root = solution.new TreeNode(1,
            solution.new TreeNode(2,
                solution.new TreeNode(4),
                solution.new TreeNode(5)),
            solution.new TreeNode(3,
                solution.new TreeNode(6),
                null));

        int result = solver.maxProduct(root);
        System.out.println(result);
    }
}