class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        return drink(numBottles, numExchange, 0);
    }
    
    private int drink(int numBottles, int numExchange, int emptyBottles){
        //System.out.println("numBottles: " + numBottles + " numExchange: " + numExchange + " emptyBottles: " + emptyBottles);
        /*if (numBottles<numExchange && emptyBottles<numExchange){
            return numBottles;
        }*/
        if (numBottles == 0 && emptyBottles<numExchange) return 0;
        
        int total = numBottles;
        
        if (emptyBottles>=numExchange){
            emptyBottles -= numExchange;
            numBottles++;
            total++;
        }
        
        
        return total + drink(numBottles/numExchange, numExchange, emptyBottles+numBottles%numExchange);
    }
}
