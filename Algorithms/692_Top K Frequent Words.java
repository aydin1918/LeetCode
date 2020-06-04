class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        List<String> result = new ArrayList();
        
        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new CustomComparator());
        
        for (Map.Entry<String, Integer> el : map.entrySet()){
            queue.offer(el);
        }
        
        for (int i=0; i<k; i++){
            result.add(queue.poll().getKey());
        }
        
        return result;
    }
    
    public class CustomComparator implements Comparator<Map.Entry<String, Integer>>
    {
        @Override 
        public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2){
            String word1 = obj1.getKey();
            String word2 = obj2.getKey();
            int freq1 = obj1.getValue();
            int freq2 = obj2.getValue();
            
            if (freq1 != freq2){
                return freq2 - freq1;
            }
            else {
                return word1.compareTo(word2);
            }
        }
    }
}


/*
****************************************************************
****************************************************************
****************************************************************
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
         List<String> result = new ArrayList();
        
        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String>[] list = new ArrayList[map.size()+1];
        
        for (int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        for (Map.Entry<String, Integer> el : map.entrySet()){
            list[el.getValue()].add(el.getKey());
        }
        
        
        
        //System.out.println(map);
        
        for (int i=list.length-1; i>=0; i--){
            Collections.sort(list[i]);
            for (String str : list[i]){
                //System.out.println(str + " backet # " + i);
                result.add(str);
                k--;
                if (k==0) break;
            }
            if (k==0) break;
        }
        
        return result;
    }
}
