class Solution {
    public long countSubarrays(int[] nums, int k) {
        int a = Arrays.stream(nums).max().getAsInt();
        long result = 0;
        int left = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            if (mpp.getOrDefault(a, 0) >= k) {
                while (left < nums.length && mpp.getOrDefault(a, 0) >= k) {
                    mpp.put(nums[left], mpp.get(nums[left]) - 1);
                    left++;
                }
            }
            result += left;
        }
        return result;
    }
}