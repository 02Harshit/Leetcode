class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
         
        //filling the ans[i] with the products of elements before it (later will so for elements after it i.e. suffix)
        
        
        int curr = 1;
        for(int i=0; i<n; i++) {
            if (i == 0) {
                ans[i] = curr;
                continue;
            }
            curr = curr * nums[i-1];
            ans[i] = curr;
        }
        //multiplying the ans[i] with product of elements after it.
        curr = 1;
        for(int i=n-2; i>=0; i--) {
            curr = curr * nums[i+1];
            ans[i] = ans[i] * curr;
        }
        return ans;
    }
}