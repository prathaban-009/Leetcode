class Solution {
    public double myPow(double x, int N) {

        long n=N;

        if(n<0)n=-n;
        double result=1;
        while(n>0)
        {
            if(n%2==0)
            {
                x*=x;
                n/=2;
            }else
            {
                result*=x;
                n--;
            }
        }

        if(N<0)return 1/result;
        return result;
        
    }
}