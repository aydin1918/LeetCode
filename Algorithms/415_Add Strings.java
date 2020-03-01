class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, carry = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1){
            int a = i >= 0 ? num1.charAt(i)-'0' : 0;
            int b = j >= 0 ? num2.charAt(j)-'0' : 0;
            int sum = a + b + carry;
            //System.out.println(sum + " " + carry);
            i--;
            j--;
            builder.append(sum%10);
            carry = sum / 10;
        }

        return builder.reverse().toString();
    }
}
