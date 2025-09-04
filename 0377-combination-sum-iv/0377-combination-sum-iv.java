class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return helper(nums, target, memo);
    }

    int helper(int[] nums, int target, Integer[] memo) {
        if (target == 0) return 1; // Found a valid combination
        if (target < 0) return 0;  // Invalid path
        if (memo[target] != null) return memo[target]; // Return cached result

        int count = 0;
        for (int num : nums) {
            count += helper(nums, target - num, memo); // Try including each number
        }
        memo[target] = count; // Store result
        return count;
    }
}