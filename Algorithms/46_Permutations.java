class Solution {
    
    protected List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permute(int[] nums) {
        return Perm(nums);
    }
    
    public List<List<Integer>> Perm(int[] array) {
        int k = 0;
        int l = array.length;

        PermUtil(array, k, l);


        //System.out.println(result);
        return result;
    }

    void ConverToArray(int a[])
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i=0; i<a.length; i++)
        {
            temp.add(a[i]);
        }
        result.add(temp);
            //System.out.print(a[i] + " ");
        //System.out.println();
    }

    private void PermUtil(int[] array, int k, int l) {

        if (l == 1)
        {
            //printArr(array,array.length, temp);
            ConverToArray(array);
        }

        for (int i=0; i<l; i++)
        {
            PermUtil(array,k,l-1);
            if (l %2 == 1)
            {
                /*int temp_ = temp.get(0);
                temp.set(0, temp.get(l-1));
                temp.set(l-1, temp_);*/
                int temp_ = array[0];
                array[0] = array[l-1];
                array[l-1] = temp_;
                //System.out.println("temp: " + temp);
            }
            else
            {
                //System.out.println("temp 1: " + temp);
                /*int temp_ = temp.get(i);
                temp.set(i, temp.get(l-1));
                temp.set(l-1, temp_);*/
                int temp_ = array[i];
                array[i] = array[l-1];
                array[l-1] = temp_;
                //System.out.println("temp: " + temp);
            }
        }
        // System.out.println("k: " + k + " array[k]: " + array[k]);
    }
}
