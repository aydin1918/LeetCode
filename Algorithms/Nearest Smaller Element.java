public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < A.size(); i++) {

            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }

            stack.push(A.get(i));
        }

        return result;
    }
}
