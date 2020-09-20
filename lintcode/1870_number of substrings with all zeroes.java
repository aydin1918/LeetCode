public class Solution {
    /**
     * @param str: the string
     * @return: the number of substrings 
     */
    public int stringCount(String str) {
        int ans = 0, currCountZero=0;
        
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') {
                int start = 0;
                for (int k=0; k<currCountZero; k++){
                    start += 1;
                    ans += start;
                }
                currCountZero = 0;
            }
            else currCountZero++;
        }
        
        //System.out.println("currCountZero: " + currCountZero);
        
        if (currCountZero>0){
            int start = 0;
                for (int k=0; k<currCountZero; k++){
                    start += 1;
                    ans += start;
                }
        }
        
        return ans;
    }
}

// "0" => 1
// "00" -> 1[2] + 2[1] => 3
// "000" -> 1 + 2 + 3 => 6
// "0000" -> 1 + 2 + 3 + 4 => 10
// "00000" -> 1[5] + 2[4] + 3[3] + 4[2] + 5[1] => 15
