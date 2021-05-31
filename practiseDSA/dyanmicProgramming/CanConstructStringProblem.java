package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstructStringProblem {

    public static Map<String, Boolean> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String target = br.readLine().trim();
            String []input = br.readLine().trim().split(" ");
            int n = input.length;

            memo = new HashMap<>();
            System.out.println(canConstruct(target, input));
            System.out.println(canConstructTab(target, input));
        }
    }

    public static boolean canConstruct(String target, String[] arr){

        if(memo.containsKey(target))
            return memo.get(target);

        if(target.equals(""))
            return true;

        for(int i=0; i<arr.length; i++){
            String word = arr[i];
            if(target.startsWith(word)){
                if(canConstruct( target.substring(word.length()) , arr)){
                    memo.put(target, true);
                    return true;
                }

            }
        }
        memo.put(target, false);
        return false;
    }

    public static boolean canConstructTab(String target, String[] arr){
        boolean tab[] = new boolean[target.length()+1];
        tab[0] = true;

        for(int i= 0; i<target.length(); i++){
            if(tab[i]== true){
                String subStr = target.substring(i);
                for(String word : arr){
                    if(word.length() <= subStr.length() && subStr.startsWith(word)){
                        tab[i+word.length()] = true;
                    }
                }
            }
        }

        return tab[target.length()];
    }

}


/*
skateboard
bo rd ate t ska sk boar
false

purple
purp p ur le
true

abcdef
ab abc cd def abcd
true
*/
