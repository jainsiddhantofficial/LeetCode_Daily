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
        int Camera=0;
        public int minCameraCover(TreeNode root) {
            int c=minCamera(root);
            if(c == -1)
            {
                Camera++;
            }
            return Camera;
        }
        public int minCamera(TreeNode root)
        {
            if( root == null)
            {
                return 0;
            }
            int left=minCamera(root.left);
            int right=minCamera(root.right);
            if( left==-1 || right ==-1) // Is node par camere ki need hai..
            {
                Camera++;
                return 1;// Camera setup kara hai..
            }
            
            if(left==1 || right==1)// inme mein se kisi ek ke pass ya dono ke pass camera h or ek ke pass ke pass and dusra wala covered hai
            {
                return 0; // As a parent hum covered hai
            }
            else {
                return -1; //need a camera
            }
        }
    }