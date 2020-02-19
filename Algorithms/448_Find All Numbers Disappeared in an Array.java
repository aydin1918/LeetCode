/*
    My solution
*/ 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length+1];
        List<Integer> res = new ArrayList<Integer>();
        
        Arrays.fill(arr,0);
        
        for (int i=0; i<nums.length; i++){
            if (arr[nums[i]] == 0 ){
                arr[nums[i]] = nums[i];
            }
            //System.out.println("nums[i]: " + nums[i] + " arr[nums[i]]: " + arr[nums[i]]);
        }
        
        for (int i=1; i<arr.length; i++){
            if (arr[i] == 0){
                res.add(i);
            }
            //System.out.println("arr[i]: " + arr[i] + " i: " + i);
        }
        
        return res;
    }
}

/*
   Internet solution
*/

public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
