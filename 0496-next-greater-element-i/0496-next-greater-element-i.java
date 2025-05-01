class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {   
         
        HashMap<Integer,Integer> map = new HashMap<>(); 

        for(int i=0; i<nums2.length-1; i++){
            map.put(nums2[i],-1);
            for(int j=i+1; j<nums2.length; j++){
                if(nums2[i] < nums2[j]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        } 
        
        map.put(nums2[nums2.length-1],-1);

        int[] answer = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            answer[i] = map.get(nums1[i]);
        }

        return answer;
    }
}