class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return Integer.compare(o1.length(), o2.length());
                }
                return o1.compareTo(o2);
            }
        });

        for (String num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.remove();
    }
}