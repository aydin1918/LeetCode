/*

Write a function that converts a binary tree represented as a list of (parent child) pairs into a nested symbolic expression.

Input1:

"(B,C) (C,D) (B,A)"
Output1:

"(B(A)(C(D)))"
Input2:

"(D,E) (F,G) (B,H) (A,B) (B,C) (C,D) (E,F)"
Output2:

"(A(B(C(D(E(F(G)))))(H)))"
[execution time limit] 3 seconds (java)

[input] string edges

A string containing a list of edges "(A,B) (A,C)"

Nodes represented as capital letters A-Z.
Edges can be presented in any order.

[output] string

A nested symbolic expression representing the tree: "(A(B)(C))"

To keep the output independent from the order the edges have been presented in, resulting trees should print the nodes sorted lexicographically. So while: "(A(B)(C))" and "(A(C)(B))" both represent the same tree "(A(B)(C))" should be the response.

If edge list does not result in a valid binary tree, a string "E" should be returned.

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        String s = "(D,E) (F,G) (B,H) (A,B) (B,C) (C,D) (E,F)";
        String[] arr = s.split(" ");

        List<Character>[] graph = new List[26];

        for (int i = 0; i < arr.length; i++) {
            String node = arr[i];
            Character source = node.substring(1, 2).charAt(0);
            Character dest = node.substring(3, 4).charAt(0);
            if (graph[source - 'A'] == null) graph[source - 'A'] = new ArrayList<>();

            graph[source - 'A'].add(dest);
            Collections.sort(graph[source - 'A']);
        }

        StringBuilder b = new StringBuilder();
        Character begin = null;

        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null) continue;
            begin = (char) (i + 'A');
            break;
            //System.out.println(graph[i]);
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null) continue;
             System.out.println((char) (i + 'A') + " " + graph[i]);
        }

        //for (int i=0; i<graph[begin-'A'].size(); i++){
        dfs(graph, b, begin);
       // }


        System.out.println(b);

    }

    private static void dfs(List<Character>[] graph, StringBuilder b, Character startNode) {
        if (graph[startNode-'A'] == null) {
            b.append('(');
            b.append(startNode);
            b.append(')');
            return;
        }
        b.append('(');
        b.append(startNode);
        for (int i = 0; i < graph[startNode-'A'].size(); i++) {

            dfs(graph, b, graph[startNode-'A'].get(i));
        }
        b.append(')');
    }


}
