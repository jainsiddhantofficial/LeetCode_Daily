class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minSum=0;
        int maxSum=0;
        int prefixSum=0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            minSum=Math.min(minSum, prefixSum);
            maxSum=Math.max(maxSum, prefixSum);
        }

        return maxSum-minSum;
    }
}