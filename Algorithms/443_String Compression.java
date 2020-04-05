class Solution {
    public int compress(char[] chars) {
        int index=0, indexPrev = 0;
        
        if (chars.length == 1) return 1;
        
        while(index < chars.length){
            char current = chars[index];
            
            int countChar = 0;
            
            while(index<chars.length && chars[index] == current){
                countChar++;
                index++;
            }
            //System.out.println(current + " " + countChar + " " + (indexPrev+1));
            //chars[indexPrev++] = (char)(countChar+ '0');
            chars[indexPrev++] = current;
            if (countChar>1){
                /*for (char c : Integer.toString(countChar).toCharArray()){
                    chars[indexPrev++] = c;
                }*/
                while (countChar/10>0){
                    int q = countChar / 10;
                    countChar %= 10;
                    chars[indexPrev++] = (char)(q+ '0');
                }
                chars[indexPrev++] =  (char)(countChar+ '0');
            }
        }
        
        return indexPrev;
    }
}
