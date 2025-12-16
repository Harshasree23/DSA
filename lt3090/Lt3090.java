import java.util.HashMap;

public class Lt3090{

    public static void main(String args[])
    {
        Solution sol = new Solution();
        String s = "aaaa";
        int res = sol.maximumLengthSubstring(s);
        System.out.println(res);
    }
}

// Sample output: 2

// Solution method - Sliding Window + HashMap
// Time Complexity: O(N)
// Space Complexity: O(1) - since the character set is limited (e.g., ASCII)

class Solution 
{
    public int maximumLengthSubstring(String s) 
    {
        int left = 0, right = 0;
        int ans = 0;
        int n = s.length();

        HashMap<Character ,Integer> alpha = new HashMap<>();

        for(right=0;right<n;right++)
        {
            char x = s.charAt(right);
            alpha.put( x , alpha.getOrDefault(x,0) + 1 );

            while(alpha.get(x)>2)
            {
                char lc = s.charAt(left);
                alpha.put( lc , alpha.get(lc)-1 );
                if( alpha.get(lc)<=0 )
                    alpha.remove(lc);
                left++;
            }

            ans = Math.max( ans , right-left+1 );
        }    

        return ans;
    }
}