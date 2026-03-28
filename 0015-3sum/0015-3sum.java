class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            int j = i+1;
            int k = n-1;
            if (i>0 && nums[i] == nums[i-1]) continue;
            while (j < k) {
                if (nums[j]+nums[k]+nums[i] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                } else if (nums[j]+nums[k] < (-1*nums[i])) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}