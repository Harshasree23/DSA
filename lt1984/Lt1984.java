import java.util.Arrays;

public class Lt1984 {
    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        int[] nums = {90};
        int k = 1;
        System.out.println(sol.minimumDifference(nums, k));
    }
}

// LeetCode Problem 1984: Minimum Difference Between Highest and Lowest of K Scores
// Method: Sorting and Sliding Window
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) if we ignore the input storage

class Solution 
{
    public int minimumDifference(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<=n-k;i++)
            ans = Math.min(ans, nums[i+k-1]-nums[i]);
        
        return ans;
    }
}