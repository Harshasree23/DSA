public class Lt2760 
{
    public static void main(String[] args) 
    {
        Solution sl = new Solution();
        int[] nums = {3,2,5,4};
        int threshold = 5;
        System.out.println( sl.longestAlternatingSubarray(nums, threshold) );
    }    
}

// LeetCode 2760. Longest Even Odd Subarray With Threshold
// sliding window
// time: O(n)
// space: O(1)

class Solution 
{
    public int longestAlternatingSubarray(int[] nums, int threshold) 
    {
        int ans = 0;
        int len = 1;
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            len=1;
            if(nums[i]%2!=0)
                continue;

            if(nums[i]>threshold)
                continue;

            while( (i+1<n) && (nums[i]%2 != nums[i+1]%2) && nums[i]<=threshold && nums[i+1]<=threshold )
            {
                len++;
                i++;
            }
            ans = Math.max(ans,len);
        }    

        return ans;
    }
}