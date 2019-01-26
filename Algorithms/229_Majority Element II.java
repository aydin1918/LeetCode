class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int numsLength = nums.length;
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++)
        {
            if (temp.containsKey(nums[i]))
            {
                int tempCount = temp.get(nums[i]);
                temp.put(nums[i], tempCount+1);
            }
            else
            {
                temp.put(nums[i],1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
              System.out.println(entry.getValue());
              if ((entry.getValue()>=numsLength/3+1 && numsLength>3) || (numsLength<=3 && entry.getValue()>1) || (numsLength<=2))  // 
              {
                  result.add(entry.getKey());
              }
          }
        
        return result;
    }
}
