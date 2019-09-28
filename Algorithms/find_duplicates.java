public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        
        boolean[] flag = new boolean[a.size()];
        int result = -1;
        for (int i=0; i<a.size(); i++)
        {
            if (flag[a.get(i)])
            {
                return a.get(i);
            }
            flag[a.get(i)] = true;        
        }
        return result ;
    }
}

//--------------------------------------------------------

void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[ Math.abs(arr[i])] >= 0) 
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  
    
    
//--------------------------------------------------------

public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        // Important! Understrand this. Similar idea to finding a loop in
        // a linked list. Floyd's cycle detection.
        int slow = 0, fast = 0;
        do{
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        }while(slow != fast);
        // They meet somewhere in the loop
        slow = 0;
        while(slow != fast){
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }
}
