import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    List<String> minimumDebtMembers(List<debtRecord> records){
        List<String> ans = new ArrayList();
        HashMap<String, Integer> map = new HashMap(); // name, balance
        TreeMap<Integer, List<String>> orderedMap = new TreeMap();
        
        for (debtRecord debt : records){
            if (map.containsKey(debt.borrower)){
                map.put(debt.borrower, map.get(debt.borrower)-debt.amount);
            }
            else {
                map.putIfAbsent(debt.borrower, debt.amount * -1);
            }
            
            if (map.containsKey(debt.lender)){
                map.put(debt.lender, map.get(debt.lender)+debt.amount);
            }
            else {
                map.putIfAbsent(debt.lender , debt.amount);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> el : map.entrySet()){
            if (el.getValue() >=0 ) continue;
            orderedMap.putIfAbsent(el.getValue(), new ArrayList());
            orderedMap.get(el.getValue()).add(el.getKey());
        }
        if (orderedMap.size()>0) ans.addAll(orderedMap.get(orderedMap.firstKey()) );
        Collections.sort(ans);
        //System.out.println(map);
        if (ans.size()==0) ans.add("Nobody has a negative balance");
        return ans;
    }
}
