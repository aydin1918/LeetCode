public class Solution {
    
    Stack<Integer> st = new Stack<>();
    
    public int evalRPN(ArrayList<String> A) {
         
        int n = A.size();
        for (int i=0; i<A.size(); i++) {
            if ("*/-+".contains(A.get(i))) {
                int a = st.pop();
                int b = st.pop();
                
                if (A.get(i).equals("+")) {
                    st.push(b+a);
                }
                else if (A.get(i).equals("-")) {
                    st.push(b-a);
                }
                else if (A.get(i).equals("*")) {
                    st.push(b*a);
                }
                else {
                    st.push(b/a);
                }
            }
            else {
                st.push(Integer.parseInt(A.get(i)));
            }
        }
        
        return st.peek();
        
    }
    
    public static int check(ArrayList<String> list)
    {


        Stack<Integer> stack = new Stack<>();
        int result=0;

        for (int i=0; i<list.size(); i++)
        {


            if (list.get(i) == "*" || list.get(i) == "+"
                    || list.get(i) == "/" || list.get(i) == "-")
            {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (list.get(i))
                {
                    case ("*"):
                        result = operand1 * operand2;
                        break;
                    case ("-"):
                        result = operand1 - operand2;
                        break;
                    case ("+"):
                        result = operand1 + operand2;
                        break;
                    case ("/"):
                        result = operand1 / operand2;
                        break;
                }
                //System.out.println(result);
                stack.push(result);
            }
            else
            {

                stack.push(Integer.parseInt(list.get(i)));
            }
        }

        return stack.peek();
    }
    
}
