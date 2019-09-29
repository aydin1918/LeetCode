static int floorSqrt(int x) 
    { 
        // Base cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Staring from 1, try all numbers until 
        // i*i is greater than or equal to x. 
        int i = 1, result = 1; 
          
        while (result <= x) { 
            i++; 
            result = i * i; 
        } 
        return i - 1; 
    } 
    
    //-----------------------------------
    
    int start = 1, end = a, result = 0;
		
		while (start<=end)
		{
			int mid = (start + end) / 2;
			
			if (mid * mid == a)
			{
				return mid;
			}
			if (mid * mid < a)
			{
				start = mid + 1;
				result = mid;
			}
			else
			{
				end = mid-1;
			}
		}
		
		return result;
