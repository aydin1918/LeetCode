class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-3; i++){
            
            if(nums[i]*4>target) break;// Too Big!!
            if(nums[i]+3*nums[nums.length-1]<target) continue;//Too Small
            if (i>0 && nums[i] == nums[i-1]) continue;
            
            for (int j=i+1; j<nums.length-2; j++){
                
                if(j>i+1 && nums[j]==nums[j-1])continue; 
                if(nums[j]*3>target-nums[i]) break;//Too Big
                if(nums[j]+2*nums[nums.length-1]<target-nums[i]) continue;// Too Small
                
                int low=j+1, high = nums.length-1;
                while (low<high){
                    int sum = nums[i] + nums[low] + nums[high] + nums[j];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        
                        low++;
                        high--;
                    }
                    else if (sum > target) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }
        
        return result;
    }
}
