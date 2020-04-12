class Solution {
    public String multiply(String num1, String num2) {
        List<String> list = new ArrayList();
        int tailZero = 0; //, result = 0;
        StringBuilder result = new StringBuilder();
        
        for (int i=num1.length()-1; i>=0; i--){
            int dummy = 0;
            StringBuilder sum = new StringBuilder();
            for (int j=num2.length()-1; j>=0; j--){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                //System.out.println(a+ " " + b);
                String e = String.valueOf((a * b)+dummy);
                
                
                if (e.length()==2){
                    sum.insert(0, e.charAt(1));
                    dummy = e.charAt(0)-'0';
                }
                else {
                    sum.insert(0, e.charAt(0));
                    dummy = 0;
                }
                //System.out.println(a+ " " + b + " " + e + " (a * b): " + (a * b) + " dummy: " + dummy);
            }
            
            for (int tail=0; tail<tailZero; tail++){
                sum.append("0");
            }
            if (dummy!=0){
                sum.insert(0, String.valueOf(dummy));
            }
            tailZero++;
            list.add(sum.toString());
        }
        
        for (int i=0; i<list.size(); i++){
            String temp = addStrings(list.get(i), result.toString());
           
            result.delete(0, result.length());
            result.append(temp);
        }
        
        //System.out.println(list);
        
        return result.charAt(0) == '0' ? String.valueOf(0) : result.toString();
    }
    
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
