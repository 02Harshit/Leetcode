class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0; i<n; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                ans[0] = map.get(need);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}