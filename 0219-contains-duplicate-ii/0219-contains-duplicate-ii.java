class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
// Creating a "detective set" - a set (HashSet) for storing suspects (numbers).
        Set<Integer> set = new HashSet<>(); 

        // We go through each number in the array, as if we were going through every house on the street.
        for (int i = 0; i < nums.length; i++) {
// "Wow! Have we seen this number before?" - we are checking whether there is a current number in our set of suspects.
            if (set.contains(nums[i])) return true; 
            // If yes, it means that we have two identical numbers at a distance of no more than k, we return true.

            // If the number is new, add it to our "detective set".
            set.add(nums[i]); 

            // "Our detective set is too big! We need to remove the old evidence."
// If the number of suspects in the set is greater than the allowed distance k...
if (set.size() > k) {
// ...we remove the oldest number from the set (the number that was k positions ago).
                set.remove(nums[i - k]); 
            }
        }

        // If we walked the whole street and didn't find two identical suspects at close range,
        // so there are no duplicates, we return false.
        return false; 
    }
}