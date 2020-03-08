class Solution {
    public boolean isPerfectSquare(int num) {
        
        long left = 0, right = num;
        
        while (left<=right){
            long mid = left + (right-left)/2;
            long t = mid * mid;
            if (num == t ) return true;
            else if (num > t){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return false;
    }
}
