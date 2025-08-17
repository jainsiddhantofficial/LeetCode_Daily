import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            table.put(num, true);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!table.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }
}