class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];

        //calculating prefix product
        pre[0] = 1; //cause no prefix for first element
        int curr = 1;
        for(int i=1; i<n; i++) {
            curr = curr*nums[i-1]; 
            pre[i] = curr;
        }

        //calculating suffix product
        suff[n-1] = 1;
        curr = 1;
        for(int i=n-2; i>=0; i--) {
            curr = curr * nums[i+1];
            suff[i] = curr;
        }

        int ans[] = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }
}