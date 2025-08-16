/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return find(root , limit , 0);
    }
    public TreeNode find(TreeNode root , int limit , int sum) {
        if(root == null) {
            return null;
        }
        sum+=root.val;
        if(root.left == null && root.right == null) { // if left and right are null that means the node is a leaf node 
            if( sum < limit ) { // if sum from root to leaf is less than limit we dont need the node so return null
                return null;
            }
            return root; // sum is greater than limit so we can take in the node
        }
        TreeNode left  = find(root.left,limit,sum);
        TreeNode right = find(root.right,limit,sum);
        if(left == null && right == null) { // if the node is not leaf but both left and right are null means the sum till node is not valid so we dont need the node 
            return null;
        } 
		//if left or right or both are not null that means a path till node is valid so populate node with left and right and return node
        root.left = left;
        root.right = right;
        return root;
    }
}