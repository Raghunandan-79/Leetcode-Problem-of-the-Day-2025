package january;

public class Jan9SmallestSubtreeWithAllTheDeepestNodes {
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
        /**
         * Helper class to store a tree node and its depth.
         */
        private static class Pair {
            TreeNode node;
            int depth;

            Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
            }
        }

        /**
         * DFS to find the smallest subtree containing all deepest nodes.
         * Returns a Pair with the subtree root and its maximum depth.
         */
        private Pair dfs(TreeNode root) {
            // Base case: null node has depth 0
            if (root == null) {
            return new Pair(null, 0);
            }

            // Recursively process left and right subtrees
            Pair left = dfs(root.left);
            Pair right = dfs(root.right);

            // If left subtree is deeper, deepest nodes are in left subtree
            if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
            }

            // If right subtree is deeper, deepest nodes are in right subtree
            if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
            }

            // If both subtrees have same depth, current node is the LCA of all deepest nodes
            return new Pair(root, left.depth + 1);
        }

        /**
         * Find the smallest subtree with all the deepest nodes.
         */
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;
        }
    }

    public static void main(String[] args) {
        Jan9SmallestSubtreeWithAllTheDeepestNodes obj = new Jan9SmallestSubtreeWithAllTheDeepestNodes();

        // Create a sample tree: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = obj.new TreeNode(3);
        root.left = obj.new TreeNode(5);
        root.right = obj.new TreeNode(1);
        root.left.left = obj.new TreeNode(6);
        root.left.right = obj.new TreeNode(2);
        root.right.left = obj.new TreeNode(0);
        root.right.right = obj.new TreeNode(8);
        root.left.right.left = obj.new TreeNode(7);
        root.left.right.right = obj.new TreeNode(4);

        Solution solution = obj.new Solution();
        TreeNode result = solution.subtreeWithAllDeepest(root);

        System.out.println(result.val);
    }
}
