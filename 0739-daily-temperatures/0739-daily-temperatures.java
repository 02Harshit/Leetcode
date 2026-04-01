class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,0);
        for(int i=0; i<n; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int prevTempIndex = stack.pop();
                ans[prevTempIndex] = i-prevTempIndex; 
            }
            stack.push(i);
        }
        return ans;
    }
}