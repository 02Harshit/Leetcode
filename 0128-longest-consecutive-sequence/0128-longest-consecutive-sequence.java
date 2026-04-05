class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int prev = 0;
        int flag = -1;
        int maxLen = 1;
        int length = 1;
        for (Integer i : map.keySet()) {
            if (flag == -1) {
                prev = i;
                flag++;
                continue;
            }
            if (flag != -1 && i - prev == 1) {
                length++;
                maxLen = Math.max(length,maxLen);
            } else {
                length = 1;
            }
            prev = i;
            flag++;
        }
        return maxLen;
    }
}