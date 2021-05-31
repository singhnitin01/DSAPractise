package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstructProblem {
    public static Map<String, List<List<String>>> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String target = br.readLine().trim();
            String []input = br.readLine().trim().split(" ");
            int n = input.length;

            memo = new HashMap<>();
            System.out.println(allConstruct(target, input));
            System.out.println(allConstructTab(target, input));
        }
    }

    public static List<List<String>> allConstruct(String target, String arr[]){

        if(memo.containsKey(target))
            return memo.get(target);

        if(target.equals(""))
            return new ArrayList<>();

        List<List<String>> newList = null;

        for(int i=0; i<arr.length; i++){
            String word = arr[i];
            if(target.startsWith(word)){
                List<List<String>> retList = allConstruct( target.substring(word.length()) , arr);


                if(retList != null){
                    if(newList == null)
                        newList = new ArrayList<>();
                    //List<List<String>> retList1 = new ArrayList<>(retList);
                    if(retList.size()!=0){
                        for(int j = 0; j<retList.size();j++){
                            List<String> copyList = new ArrayList<>(retList.get(j));
                            copyList.add(word);
                            newList.add(copyList);
                        }
                    }
                    else {
                        List<String> list = new ArrayList<>();
                        list.add(word);
                        newList.add(list);
                    }
                }
            }
        }
        memo.put(target, newList);
        return newList;
    }


    public static List<List<String>> allConstructTab(String target, String arr[]){
        List<List<String>> []tab = new List[target.length()+1];

        List<List<String>> list  = new ArrayList<>();
        list.add(new ArrayList<>());
        tab[0] = list;

        for(int i=0; i<target.length(); i++){
            if(tab[i] != null){
                List<List<String>> retList = tab[i];
                String subStr = target.substring(i);
                for(String word: arr){
                    if(word.length() <= subStr.length() && subStr.startsWith(word)){
                        list = tab[word.length()+i];
                        if(list == null)
                            list = new ArrayList<>();

                        for(List<String> inList: retList){
                            List<String> copyList = new ArrayList<>(inList);
                            copyList.add(word);
                            list.add(copyList);
                        }
                        tab[i+word.length()] = list;
                    }
                }
            }
        }

        return tab[target.length()];
    }
    
}

/*
enterapotentpot
a p ent enter ot t o
[[ot, p, ent, ot, p, a, enter], [t, o, p, ent, ot, p, a, enter], [ot, p, ent, t, o, p, a, enter], [t, o, p, ent, t, o, p, a, enter]]
[[enter, a, p, ot, ent, p, ot], [enter, a, p, o, t, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, o, t]]

abcdef
ab abc cd def abcd ef
[[ef, cd, ab], [def, abc], [ef, abcd]]
[[abc, def], [abcd, ef], [ab, cd, ef]]

abcdef
ab abc cd def abcd ef c
[[ef, cd, ab], [def, c, ab], [def, abc], [ef, abcd]]
[[abc, def], [ab, c, def], [abcd, ef], [ab, cd, ef]]

purple
purp p ur le purpl
[[le, purp], [le, p, ur, p]]
[[purp, le], [p, ur, p, le]]

eeeeeeeeeef
e ee eee eeee eeeee
null


skateboard
sk ate boar bo rd ska t

*/
