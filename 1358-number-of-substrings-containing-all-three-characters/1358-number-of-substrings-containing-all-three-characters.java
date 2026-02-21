class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<n; j++) {
                set.add(s.charAt(j));
                if (set.size() >= 3) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }
}