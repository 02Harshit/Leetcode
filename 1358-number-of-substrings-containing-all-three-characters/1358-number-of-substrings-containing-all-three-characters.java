class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int l = 0, r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (r < n) {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            while(map.size() == 3) {
                count += n-r; //all possible added
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;   
                
            }

            r++;
        }
        return count;
    }
}