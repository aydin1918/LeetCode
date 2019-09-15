class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;  //numbers[0], numbers[numbers.length-1];
        while (i<j)
        {
            if (numbers[i]+numbers[j] > target )
            {
                j--;
            }
            else if (numbers[i]+numbers[j] < target)
            {
                i++;
            }
            else if (numbers[i]+numbers[j] == target)
            {
                break;
            }
        }
        return new int[]{i+1,j+1};
    }
}
