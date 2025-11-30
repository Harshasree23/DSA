var minSubarray = function(nums, p) {
    
    const sum = nums.reduce((a,c)=>a+c,0);

    var rem = sum%p ;
    if( rem == 0 ) return 0;
    if( sum < p ) return -1;

    const map = new Map();
    map.set(0,-1);
    var pre = 0;
    var ans = nums.length;

    for(var i=0;i<nums.length;i++)
    {
        pre = (pre+nums[i])%p;
        map.set(pre,i);
        var needed = (pre-rem+p)%p;
        if( map.has(needed) )
            ans = Math.min( ans, i-map.get(needed) );
    }

    return ans==nums.length ? -1 : ans;
};


console.log(minSubarray( [3,1,4,2], 6 )); // Output: 1
console.log(minSubarray( [6,3,5,2], 9 )); // Output: 2
console.log(minSubarray( [1,2,3], 3 )); // Output: 0