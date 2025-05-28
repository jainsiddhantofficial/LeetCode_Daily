// BRUTE
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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String>li=new ArrayList<>();
        String s="";
        bi(root,li,s);
        return li;
    }
     void bi(TreeNode root,ArrayList<String>li,String s){
        if(root==null)return;
         if(root.left==null&&root.right==null){
            s+=root.val;
            li.add(s);
            s="";
            return;
        }
        s+=root.val;
        s+="->";
        if(root.left!=null)bi(root.left,li,s);
        if(root.right!=null)bi(root.right,li,s);
     }
}