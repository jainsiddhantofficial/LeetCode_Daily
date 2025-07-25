class Solution {
    public static int findRadius(int[] houses, int[] heaters) {
        
    	int n = houses.length;
    	Arrays.sort(houses);
    	Arrays.sort(heaters);
    	int ans = 0;
    	
    	for (int i = 0; i < n; i++) {
			
    		int l = 0;
    		int r = heaters.length-1;
            int house = houses[i];
    		int minDist = Integer.MAX_VALUE;
    		
    		while(l<=r) {
    			
    			int mid = l + (r-l)/2;
    			
    			int heater = heaters[mid];
    			int diff = Math.abs(heater - house);
    			minDist = Math.min(minDist, diff);
    			
    			if(heater < house) {
    				l = mid + 1;
    			} else {
    				r = mid - 1;
    			}
    			
    		}
    		
    		ans = Math.max(ans, minDist);
		}
    	return ans;
    }
}