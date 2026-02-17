class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hash[] = new int[256];
        Arrays.fill(hash,-1); //-1 means not seen till now
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right<n; right++) {
            if (hash[s.charAt(right)] != -1) { //is the character seen before?
                if (hash[s.charAt(right)] >= left) { //if yes, then does it lie ahead of left?
                    left = hash[s.charAt(right)] + 1; //if yes,shrink the window by moving left ahead
                }
            }
            maxLength = Math.max(right-left+1,maxLength);
            hash[s.charAt(right)] = right; //mark the char as visited on curr index
        }

        return maxLength;
    }
}