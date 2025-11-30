import java.util.HashMap;   

public class Lt1590{

    public static void main(String args[]){
        Solution sol = new Solution();

        System.out.println(sol.minSubarray( new int[]{ 3,1,4,2 }, 6 )); // Output: 1
        System.out.println(sol.minSubarray( new int[]{6,3,5,2 }, 9 )); // Output: 2
        System.out.println(sol.minSubarray( new int[]{ 1,2,3 }, 3 )); // Output: 0

    }
}

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;

        int rem = (int)(total % p);
        if (rem == 0) return 0; // already divisible

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // prefix before starting

        long prefix = 0;
        int ans = nums.length;

        for (int j = 0; j < nums.length; j++) {
            prefix = (prefix + nums[j]) % p;

            int needed = (int)((prefix - rem + p) % p);

            if (map.containsKey(needed)) {
                ans = Math.min(ans, j - map.get(needed));
            }

            map.put((int)prefix, j);
        }

        return ans == nums.length ? -1 : ans;
    }
}
