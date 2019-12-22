static public void main(String[] args) {

        int[] array = new int[]{1, 2, 5};  //
        int[][] matrix = new int[][]{
                {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
        };

        //System.out.println("123".substring(0,2));
        //System.out.println(test("Anshuman","Antihuman", 0));
        //mMatrix(new int[][]{{1, 0, 1},{1, 1, 1},{1, 1, 1}});

        /*Sort sort = new Sort();

        int[] array1 = new int[]{80,30,20,40,50,70, 90, 100};

        new int[]{2,5,10,1} - 27
        sort.mergeSort(array1, 0 , 7);

        for (int i=0; i<array1.length; i++)
        {
            System.out.print(array1[i] + " ");
        }*/

        String str = "aaaabaaa";

        //Arrays.sort(array);

        //System.out.println(perfectSquare(12));
        //System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(check("fffaaaaabbb"));
    }

    public static int check(String s)
    {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> uniqueInList = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        //ArrayList<Character> result = new ArrayList<>();
        int k = 0,result=Integer.MAX_VALUE,tempResult=0;

        for (int i=0; i<s.length(); i++)
        {
            if (!set.contains(s.charAt(i)))
            {
                set.add(s.charAt(i));
            }
        }


        for (int i=0; i<s.length(); i++)
        {
            for (int j=i; j<s.length(); j++)
            {
               //uniqueInList.add(s.charAt(i - j + 1)); // .charAt(k)  s.substring(j,i)
                String str = s.substring(i,j+1);
                System.out.println(str + " " + checkTwoStr(str, set ) + " " + str.length());

                if (checkTwoStr(str, set ))
                {
                    //System.out.print( " -" + Math.min(str.length(), result) + " ");
                    result = Math.min(str.length(), result);
                }
            }

        }

        System.out.println(set.toString());

        return result;
    }

    public static boolean checkTwoStr(String str, HashSet<Character> set)
    {
        HashSet<Character> setTemp = new HashSet<>();
        setTemp.addAll(set);

        //System.out.println(setTemp.toString() + " " + set.toString());

        for (int i=0; i<str.length(); i++)
        {
            if (setTemp.contains(str.charAt(i)))
            {
                setTemp.remove(str.charAt(i));
            }
        }
        return setTemp.isEmpty();
    }
