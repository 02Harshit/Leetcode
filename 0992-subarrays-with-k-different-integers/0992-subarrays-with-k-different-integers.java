class Solution {
    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0,l=0,n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int r = 0; r<n; r++) {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while (map.size() > k) {
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            count += r-l+1;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums,k) - subarraysWithAtMostKDistinct(nums,k-1);
    } 
}