class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        
        for (int i=0; i<=heights.length; i++){
            int cur = (i==heights.length ? -1 : heights[i]);
            while (!stack.isEmpty() && heights[stack.peek()] > cur){
                int height = heights[stack.pop()];
                int pos = stack.isEmpty() ? i : i - stack.peek()-1;
                maxArea = Math.max(maxArea, height * pos);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
