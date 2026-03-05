class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        int count2 = 1;
        char prev = s.charAt(0);
        if (s.length() <= 1) return 0;
        for(int i=1; i<s.length(); i++) {
            if (s.charAt(i) == prev) {
                count1++;
                if (s.charAt(i) == '1') prev = '0';
                else prev = '1';
            } else {
                prev = s.charAt(i);
            }
        }
        prev = s.charAt(0) == '1' ? '0' : '1';
        for(int i=1; i<s.length(); i++) {
            if (s.charAt(i) == prev) {
                count2++;
                if (s.charAt(i) == '1') prev = '0';
                else prev = '1';
            } else {
                prev = s.charAt(i);
            }
        }

        return Math.min(count1,count2);
    }
}