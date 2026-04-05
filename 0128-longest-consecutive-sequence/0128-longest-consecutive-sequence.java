class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }
        int maxLen = 1;
        for (int i : nums) {
            if (set.contains(i-1)) continue;
            else {
                int length = 1;
                while (set.contains(i+1)) {
                    length++;
                    maxLen = Math.max(length,maxLen);
                    i++;
                }
            }
        }
        return maxLen;
    }
}