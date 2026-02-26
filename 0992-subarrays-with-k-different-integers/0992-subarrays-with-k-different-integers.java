class Solution {
    private static int subarrayWithatMostKDistinct(int nums[], int k) {
        int l=0, count = 0,n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(); 
        
        for(int r=0; r<n; r++) {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while (map.size() > k) {
                map.put(nums[l],map.get(nums[l])-1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            if (map.size() <= k) count+= r-l+1;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // System.out.println(subarrayWithatMostKDistinct(nums,k));
        // System.out.println(subarrayWithatMostKDistinct(nums,k-1));
        return  subarrayWithatMostKDistinct(nums,k) - subarrayWithatMostKDistinct(nums,k-1);
    }
}