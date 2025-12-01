var maxArea = function(height) {
    var lp=0,rp=height.length-1;
    var ans=0;
    while(lp<rp)
    {
        ans = Math.max( ans , Math.min(height[lp],height[rp]) * (rp-lp) );
        if( height[lp]<height[rp] ) lp++;
        else rp--;
    }
    return ans;
};





console.log(maxArea([1,8,6,2,5,4,8,3,7]));