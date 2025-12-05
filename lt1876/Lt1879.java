public class Lt1879 {
    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        String s = "xyzzaz";
        int ans = sol.countGoodSubstrings(s);
        System.out.println(ans);
    }
}

// Brute Force
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution 
{
    public int countGoodSubstrings(String s) 
    {
        int ans=0;
        int n = s.length();
        char arr[] = s.toCharArray();

        for(int i=0;i<n;i++)
        {
            if( (i<n-2) && !(arr[i]==arr[i+1] || arr[i]==arr[i+2] || arr[i+1]==arr[i+2]))
                ans++;
        }

        return ans;    
    }
}

// Sliding Window
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution2
{
    public int countGoodSubstrings(String s) 
    {
        int n = s.length();
        if(n < 3)
            return 0;

        int ans = 0;
        char arr[] = s.toCharArray();

        // window size = 3
        for(int i = 0; i < n - 2; i++)
        {
            char a = arr[i];
            char b = arr[i+1];
            char c = arr[i+2];

            if(a != b && a != c && b != c)
                ans++;
        }

        return ans;
    }
}