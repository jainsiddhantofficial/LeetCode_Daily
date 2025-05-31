class Solution {
    public void moveZeroes(int[] nums) {
        int nonzero = 0; // Pointer to place the next non-zero element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap non-zero element with the element at `nonzero`
                int temp = nums[i];
                nums[i] = nums[nonzero];
                nums[nonzero] = temp;
                nonzero++; // Increment the nonzero pointer
            }
        }
    }
}