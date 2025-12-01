import java.util.HashSet;

public class Lt219 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println( sol.containsNearbyDuplicate(nums, k) );
    }
}

// Brute Force Approach   
// 54/65 test cases passed
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]==nums[j] && j-i<=k)
                    return true;
            }
        }
        return false;
    }
}



// Optimized Brute Force Approach
// 65/65 test cases passed
// Time Complexity: O( n * min(n,k) )
// Space Complexity: O(1)

class Solution1 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=i+k && j<n;j++)
            {
                if(nums[i]==nums[j] && j-i<=k)
                    return true;
            }
        }
        return false;
    }
}


// Using HashSet
// 65/65 test cases passed
// Time Complexity: O(n)
// Space Complexity: O(k)

class Solution3 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            int curr = nums[i];
            if(i<=k){
                if( hs.contains(curr) ) return true;
                hs.add(curr);
            }
            else{
                hs.remove(nums[i-k-1]);
                if( hs.contains(curr) ) return true;
                hs.add(curr);
            }
        }

        return false;
    }
}



// Better readability and simplified code
// 65/65 test cases passed
// Time Complexity: O(n)
// Space Complexity: O(k)
class Solution4 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) 
        {
            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}