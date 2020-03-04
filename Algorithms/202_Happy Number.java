class Solution {
    public boolean isHappy(int n) {
        
        if (n<10) {
            if (n == 1 || n == 7){
                return true;
            }
            else {
                return false;
            }
        }
        
        int  sum = 0, tmp = 0;

        while (n>=1){
            tmp =  n %10 ;
            sum += tmp * tmp;
            n /= 10;
        }
        
        return isHappy(sum);
    }
}

/*
*
*
*/

class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        int sum = 0, tmp = 0;

        while (set.add(n)) {
            sum = 0;
            while (n >= 1) {
                tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }

            if (sum == 1) return true;
            else n = sum;
        }

        return false;
    }
}
