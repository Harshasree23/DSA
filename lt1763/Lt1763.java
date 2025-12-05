public class Lt1763 
{
    public static void main(String args[])
    {
        Solution sol = new Solution();
        String s = "YazaAay";
        System.out.println( sol.longestNiceSubstring(s) );
    }    
}


// Brute Force
// Time Complexity: O(N^3)
// Space Complexity: O(1)

class Solution 
{
    public String longestNiceSubstring(String s) 
    {
        int n = s.length();
        String ans = "";
        int len = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if( isNice(s.substring(i,j+1)) )
                {
                    if( (-i+j) > len )
                    {
                        len = -i+j;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }

        return ans;
    }

    static boolean isNice(String s)
    {
        int a[] = new int[26];
        int A[] = new int[26];

        for(char x: s.toCharArray())
        {
            if(x>='a' && x<='z')
                a[x-'a']++;
            else
                A[x-'A']++;
        }

        for(int i=0;i<26;i++)
            if( !( (a[i]>0 && A[i]>0) || (a[i]==A[i]) ) )
                return false;
        return true;
    }
}