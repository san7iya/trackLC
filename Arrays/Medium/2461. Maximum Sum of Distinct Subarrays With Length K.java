class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        long maxSum = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int right = 0; right < nums.length; right++) {
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            if((right - left + 1) == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[left];
                set.remove(nums[left]);
                left++;            
            }
        }

        return maxSum;
    }
}