class Solution {
    public double myPow(double x, int n) {
        return PowFunc(x,n);
    }
    
    public double PowFunc(double x, int n)
    {
        double temp;
        if (n==0)
        {
            return 1;
        }

        temp = PowFunc(x, n/2);

        if (n%2==0)
        {
            return temp * temp;
        }
        else
        {
            if (n<0)
            {
                return temp * temp / x;
            }
            else
            {
                return x * temp * temp;
            }
        }
    }
}
