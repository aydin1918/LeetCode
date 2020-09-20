public class Solution {
    /**
     * @param N:  the number of rows
     * @param S: a list of reserved seats
     * @return: nothing
     */
    public int solution(int N, String S) {
        boolean[][] seats = new boolean[N][10];
        String[] arr = S.length()>0 ? S.split(" ") : new String[]{};
        int ans = 0;
        
        for (String s : arr){
            int row = Integer.parseInt(s.substring(0, s.length()-1));
            char seat = s.substring(s.length()-1, s.length()).charAt(0);
            //System.out.println(s + " " + row + " " + (seat-'0'-17));
            seats[row-1][(seat-'0'-17)] = true;
        }
        
        for (int i=0; i<seats.length; i++){
            boolean first=false, second=false, third=false;
            if (!seats[i][1] && !seats[i][2] && !seats[i][3] && !seats[i][4]) {
                first = true;
            }
            if (!seats[i][5] && !seats[i][6] && !seats[i][7] && !seats[i][8]) {
                second = true;
            }
            if (!seats[i][3] && !seats[i][4] && !seats[i][5] && !seats[i][6]) {
                third = true;
            }
            
            if (first && second && !third) ans+=2;
            else if (first && second && third) ans+=2;
            else if (first && !second && !third) ans+=1;
            else if (!first && second && !third) ans+=1;
            else if (!first && !second && third) ans+=1;
            else if (first && !second && third) ans+=1;
            else if (!first && second && third) ans+=1;
        }
        
        return ans;
    }
}
