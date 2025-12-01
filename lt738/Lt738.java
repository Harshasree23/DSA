
class Lt738 
{
    public static void main(String[] args) 
    {
        Solution1 sol = new Solution1();
        int n = 332;
        System.out.println( sol.monotoneIncreasingDigits(n) );
    }
}

// Brute Force Approach   --TLE--( 223/308 )
class Solution1 
{
    public int monotoneIncreasingDigits(int n) 
    {
        while(n>0)
            if( checkMID(n--) ) return n+1;
        return n;
    }

    boolean checkMID(int n){
        int lastno = n%10;
        while(n>0){
            n/=10;
            if( n%10 > lastno ) return false;
            lastno = n%10;
        }
        return true;
    }
}