class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String s : strs) {
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }

            map.get(sorted).add(s);
        }
        for(ArrayList<String> l1 : map.values()) {
            ans.add(l1);
        }
        return ans;
    }
}