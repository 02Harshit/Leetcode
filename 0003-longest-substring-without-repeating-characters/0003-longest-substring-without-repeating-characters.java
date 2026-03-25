class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int r = 0; r<n; r++) {
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while (map.get(ch) > 1) {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;

        
    }
}