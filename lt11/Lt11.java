public class Lt11 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = sol.maxArea(height);
        System.out.println("The maximum area is: " + result);
    }
}

class Solution 
{
    public int maxArea(int[] height) 
    {
        int ans = 0;
        int n = height.length;

        int lp=0,rp=n-1;

        while(lp<rp)
        {
            ans = Math.max( ans , Math.min(height[lp],height[rp]) * ( rp-lp ) );
            if( height[lp] < height[rp] )
                lp++;
            else
                rp--;
        }   

        return ans;
    }
}