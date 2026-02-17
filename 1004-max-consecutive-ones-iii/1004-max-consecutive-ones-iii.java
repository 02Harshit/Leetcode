class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeroes = 0; //number of zeroes in window
        int left = 0;
        int maxLength = 0;

        for(int right=0; right<n; right++) {
            if (nums[right] == 0) zeroes++;

            while (zeroes > k && left <= right) {
                if (nums[left] == 0) zeroes--;
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }

        return maxLength;

    }
}