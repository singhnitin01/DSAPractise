package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountConstructProblem {
    public static Map<String, Integer> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String target = br.readLine().trim();
            String []input = br.readLine().trim().split(" ");
            int n = input.length;

            memo = new HashMap<>();
            System.out.println(countConstruct(target, input));
            System.out.println(countConstructTab(target, input));
        }
    }

    public static int countConstruct(String target, String arr[]){

        if(memo.containsKey(target))
            return memo.get(target);

        if(target.equals(""))
            return 1;

        int totCount = 0;
        for(int i=0; i<arr.length; i++){
            String word = arr[i];
            if(target.startsWith(word)){
                int count = countConstruct( target.substring(word.length()) , arr);
                if(count != 0){
                    //memo.put(target, true);
                    totCount += count;
                }
            }
        }
        memo.put(target, totCount);
        return totCount;
    }

    public static int countConstructTab(String target, String arr[]){
        int []tab = new int[target.length()+1];
        tab[0] = 1;

        for(int i=0; i<target.length(); i++){
            if(tab[i] != 0){
                String subStr = target.substring(i);
                for(String word : arr){
                    if(word.length() <= subStr.length() && subStr.startsWith(word))
                        tab[i+word.length()] += tab[i];
                }
            }
        }
        return tab[target.length()];
    }
}

/*
e.g.

purple
purp p ur le purpl
2
abcdef
ab abc abcd cd def
1
skateboard
sk ate boar bo rd ska t
0
enterapotentpot
a p ent enter ot t o
4
eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef
e ee eee eeee eeeee eeeeee
0
abcdef
ab abc cd def abcd ef
3
abcdef
ab abc cd def abcd
1

*/
