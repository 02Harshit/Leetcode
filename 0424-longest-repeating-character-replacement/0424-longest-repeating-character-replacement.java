class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0,maxLen=0,maxFreq=0;
        int n = s.length();
        int hash[] = new int[26];

        for(int r=0; r<n; r++) {
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r)-'A']);
            int replacements = (r-l+1) - maxFreq;

            while (replacements > k) {
                hash[s.charAt(l)-'A']--;
                l++;
                maxFreq = 0;
                for(int i=0; i<26; i++) maxFreq = Math.max(maxFreq,hash[i]);
                replacements = (r-l+1) - maxFreq;
            }

            maxLen = Math.max(maxLen,r-l+1);
        }

        return maxLen;
    }
}