import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // Collections.reverseOrder()
        
        for (int i=0; i<boxes.length; i++){
            for (int j=0; j<boxes[i]; j++){
                queue.offer(unitsPerBox[i]);
                if (queue.size() == truckSize+1){
                    queue.poll();
                }
            }
        }
        
        while (!queue.isEmpty()) sum+=queue.poll();
        
        return sum;
    }
}
