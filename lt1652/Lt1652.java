public class Lt1652 
{
    public static void main(String args[])
    {
        Solution2 sol = new Solution2();
        int code[] = {5,7,1,4};
        int k = 3;
        int ans[] = sol.decrypt(code, k);
        for(int i:ans)
            System.out.print(i+" ");
    }    
}   

// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution2 
{
    public int[] decrypt(int[] code, int k) 
    {
        int n = code.length;
        int ans[] = new int[n];

        if(k==0)
            return ans;

        int temp=0,start,end;
        
        if(k>0)
        {
            start = 1;
            end = k;
        }
        else{
            k = -k;
            start = n-k;
            end = n-1;
        }

        for(int i=start;i<=end;i++)
            temp+=code[i];
        ans[0]=temp;

        for(int i=1;i<n;i++)
        {
            temp -= code[ (start+i-1)%n ];
            temp += code[ (end+i)%n ];
            ans[i] = temp;
        }

        return ans;
    }
}



class Solution1 
{
    public int[] decrypt(int[] code, int k) 
    {
        int n = code.length;
        int rsum[] = new int[n];
        int lsum[] = new int[n];
        int temp = 0;

        if(k==0)
            return new int[n];

        if(k>0)
        {
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    for(int j=1;j<=k;j++)
                        temp+=code[ j%n ];
                }
                else{
                    temp -= code[i%n];
                    temp += code[(i+k)%n];
                }
                rsum[i] = temp;
            }    
            return rsum;

        }

        k*=-1;
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                for(int j=1;j<=k;j++)
                    temp+=code[ (n-j)%n ];
            }
            else{
                temp -= code[( (i-1-k)%n +n ) %n];
                temp += code[(i-1+n) % n];
            }
            rsum[i] = temp;
        }    
        return rsum;
    }
}