import java.util.*;
public class Solution {
  public List<String> findLargestGroup(List<List<String>> items){
      return findLargestGroup2(items);
  }
  
  private  List<String> findLargestGroup2(List<List<String>> secretFruitList){
        List<String> ans = new ArrayList<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();

        for (List<String> list : secretFruitList){
            for (String str : list){
                for (String strLeft : list){
                    if (strLeft.equals(str)) continue;
                    map.putIfAbsent(str, new HashSet<>());
                    map.putIfAbsent(strLeft, new HashSet<>());

                    map.get(str).add(strLeft);
                    map.get(strLeft).add(str);
                }

            }
        }

        //System.out.println(map);
        Map<Integer, List<List<String>>> sizeMap = new HashMap<>();
        int maxSizeRes = Integer.MIN_VALUE;
        for (String key : map.keySet()){
            Queue<String> queue = new LinkedList<>();
            TreeSet<String> tree = new TreeSet<>();
            HashSet<String> visited = new HashSet<>();
            queue.add(key);
            while (!queue.isEmpty()){
                String temp = queue.poll();
                if (visited.contains(temp)) continue;
                visited.add(temp);
                tree.add(temp);
                HashSet<String> listTemp = map.get(temp);
                for (String tempStr : listTemp){
                    queue.add(tempStr);
                }
            }
            int size = tree.size();
            maxSizeRes = Math.max(maxSizeRes, size);
            sizeMap.putIfAbsent(size, new ArrayList<>());
            sizeMap.get(size).add(new ArrayList<>(tree));
        }

        return sizeMap.get(maxSizeRes).get(0);
    }
  
}
