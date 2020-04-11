class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        
        for (int i=0; i<nums2.length; i++){
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)+1);
        }
        
        for (int i=0; i<nums1.length; i++){
            if (map.containsKey(nums1[i])){
                list.add(nums1[i]); 
                int count = map.get(nums1[i]);
                if (count>=2) {
                    map.put(nums1[i], --count);
                } 
                else {
                    map.remove(nums1[i]);
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}


/*

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j =0;
        
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]==nums2[j])    {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i]>nums2[j]){
                j++;
            }
            else {
                i++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int k=0; k<list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
}
