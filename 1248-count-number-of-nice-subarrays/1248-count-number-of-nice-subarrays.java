class Solution {
    private static int SumLessThanEqualK(int nums[], int k) {
        int l = 0,count = 0,sum = 0;
        if (k < 0) return 0;
        for(int r=0; r<nums.length; r++) {  
            sum += (nums[r] % 2);

            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }

            count += r-l+1;
        }

        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return SumLessThanEqualK(nums,k) - SumLessThanEqualK(nums,k-1);
    }
}