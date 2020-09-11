/*
* Runtime: 9 ms, faster than 61.67% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
* Memory Usage: 56.4 MB, less than 61.14% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
*
*/

class Solution {
    public int minCost(String s, int[] cost) {
        int ans = 0, sum = 0, max = 0;
        
        for (int i=0; i<s.length(); i++){
            if (i>0 && s.charAt(i-1)!=s.charAt(i)){
                ans += sum - max;
                sum = 0;
                max = 0;
            }
            
            sum += cost[i];
            max = Math.max(max, cost[i]);
            
        }
        
        ans += sum - max;
        
        return ans;
    }
}


/*
* Runtime: 18 ms, faster than 27.59% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
* Memory Usage: 47.5 MB, less than 100.00% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
*
*/


class Solution {
    public int minCost(String s, int[] cost) {
        int ans = 0;
        int[] prev = new int[]{-1,-1}; // first letter, position

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (prev[1]==-1){
                prev[0] = c-'a';
                prev[1] = i;
            }
            else {
                if (prev[0] == c-'a'){
                    int start = prev[1], end=start;
                    while (end<s.length() && s.charAt(end)==c ){
                        end++;
                    }
                    int[] newArr = Arrays.copyOfRange(cost, start, end);
                    Arrays.sort(newArr);
                    for (int k=0; k<newArr.length-1; k++){
                        ans+=newArr[k];
                    }

                    i = end-1;
                    prev[1] = -1;
                    //prev = s.charAt(end);
                }
                else {
                    prev[0] = c-'a';
                    prev[1] = i;
                }
            }
        }

        return ans;
    }
}
