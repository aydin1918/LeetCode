class Solution {
    public int[] plusOne(int[] digits) {
      int carry = 1;
        
        if(digits==null||digits.length==0)
        return new int[0];

        for (int i=digits.length-1; i>=0; i--)
        {
            System.out.println(digits[i]);
            int sum = digits[i]+carry;
            if (sum  >= 10)
            {
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            digits[i] = sum%10;
        }

        if (carry == 1)
        {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        else
        {
            return digits;
        }
    }
}
