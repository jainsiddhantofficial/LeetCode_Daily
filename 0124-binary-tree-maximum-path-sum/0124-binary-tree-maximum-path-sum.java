class Solution {
    public int maxSum(TreeNode root, int[] pathSum){
        if(root == null) return 0;

        int lSum = Math.max(0, maxSum(root.left, pathSum));   // \U0001f33f
        int rSum = Math.max(0, maxSum(root.right, pathSum));  // \U0001f33f

        pathSum[0] = Math.max(pathSum[0], lSum + rSum + root.val); // \U0001f501 Update max

        return root.val + Math.max(lSum, rSum); // \U0001f4cf Return max single path
    }

    public int maxPathSum(TreeNode root) {
        int[] pathSum = new int[1];
        pathSum[0] = Integer.MIN_VALUE;
        maxSum(root, pathSum);
        return pathSum[0];
    }
}