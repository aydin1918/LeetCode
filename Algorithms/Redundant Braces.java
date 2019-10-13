public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        int total = 0;
        for (int i=0; i<A.length(); i++)
        {

            if (A.charAt(i) == ')')
            {
                char ch = stack.pop();

                //System.out.println(ch);
                boolean flag = true;


                while (ch != '(')
                {

                    if (ch == '+' || ch == '-'
                            || ch == '*' || ch == '/') {
                        flag = false;
                    }
                    ch = stack.pop();
                }

                if (flag)
                {
                    return 1;
                }

            }
            else
            {
                stack.push(A.charAt(i));
            }
        }
        return 0;
    }
}
