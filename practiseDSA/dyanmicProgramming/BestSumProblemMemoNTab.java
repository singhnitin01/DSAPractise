package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BestSumProblemMemoNTab {
    public static Map<Integer, List<Integer>> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            int targetSum = Integer.parseInt(br.readLine().trim());
            String []input = br.readLine().trim().split(" ");
            int n = input.length;
            int arr[] = new int[n];
            for(int i=0; i< n; i++)
                arr[i] = Integer.parseInt(input[i]);

            memo = new HashMap<>();
            System.out.println(bestSum(targetSum, arr));
            System.out.println(bestSumTab(targetSum, arr));
        }
    }

    public static List<Integer> bestSum(int targetSum, int[]arr){
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if(targetSum == 0)
            return new ArrayList<>();
        if(targetSum < 0)
            return null;

        List<Integer> minList = null;

        for(int i = 0; i< arr.length; i++){
            List<Integer> retList = bestSum(targetSum - arr[i], arr);
            if(retList != null){
                List<Integer> list = new ArrayList<>(retList);
                //Collections.copy(retList, list);
                list.add(arr[i]);
                if(minList == null || minList.size() > list.size())
                    minList = list;
            }
        }
        memo.put(targetSum, minList);
        return minList;
    }
    public static List<Integer> bestSumTab(int targetSum, int[]arr){
        List<Integer> []tab = new List[targetSum+1];
        tab[0] = new ArrayList<>();

        for(int i=0; i<=targetSum; i++){
            if(tab[i] != null){
                for(int ele: arr){
                    if(ele + i <= targetSum){
                        List<Integer> list = tab[ele+i];
                        List<Integer> copyList = new ArrayList<>(tab[i]);
                        copyList.add(ele);
                        if(list==null || copyList.size() < list.size() ){
                            tab[ele+i] = copyList;
                        }
                    }
                }
            }

        }
        /*for(int i=0; i<= targetSum; i++)
            System.out.println(tab[i]);*/
        return tab[targetSum];
    }
}
/*
7, [5,3,4,7]
8, [2,3,5]
8, [1,4,7]
100, [1,2,5,25]
*/
