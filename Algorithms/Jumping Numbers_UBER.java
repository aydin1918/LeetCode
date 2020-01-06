/*
Given a positive int n, print all jumping numbers smaller than or equal to n. A number is called a jumping number if all adjacent digits in it differ by 1. For example, 8987 and 4343456 are jumping numbers, but 796 and 89098 are not. All single digit numbers are considered as jumping numbers.

Example:

Input: 105
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98, 101]
*/

public static void jumpingNumbers(int n)
    {
        Set<Integer> list = new HashSet<>();
        for (int i=0; i<=9; i++)
        {
            dfs(n, list, i);
        }
        List<Integer> res = new ArrayList<>(list);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void dfs(int number, Set<Integer> list, int i)
    {
        if (number<i) return;
        if (!list.add(i)) return;
        if (i%10==0)
        {
            dfs(number, list, i * 10 + 1);
        }
        else if (i%10==9)
        {
            dfs(number, list, i * 10 + 8);
        }
        else
        {
            dfs(number, list, i%10 + i * 10 + 1);
            dfs(number, list, i%10 + i * 10 - 1);
        }
    }
