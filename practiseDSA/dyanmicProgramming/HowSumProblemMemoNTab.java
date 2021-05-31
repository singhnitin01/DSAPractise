package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSumProblemMemoNTab {
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
            System.out.println(howSum(targetSum, arr));
            System.out.println(howSumTab(targetSum, arr));
        }
    }

    public static List<Integer> howSum(int targetSum, int[]arr){

        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        if(targetSum == 0)
            return new ArrayList<>();
        if(targetSum < 0)
            return null;


        for(int i = 0; i< arr.length; i++){
            List<Integer> retList = howSum(targetSum - arr[i], arr);
            if(retList != null){
                List<Integer> copyList = new ArrayList<>(retList);
                copyList.add(arr[i]);
                memo.put(targetSum, copyList);
                return copyList;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static List<Integer> howSumTab(int targetSum, int[]arr){
        List<Integer> []tab = new List[targetSum+1];
        tab[0] = new ArrayList<>();

        for(int i=0; i<= targetSum; i++){
            if(tab[i]!= null){
                for(int ele: arr){
                    if(ele + i <= targetSum){
                        List<Integer> copyList = new ArrayList<>(tab[i]); //
                        copyList.add(ele);
                        tab[ele+i] = copyList;
                    }
                }
            }
        }

        return tab[targetSum];
    }
}
// e.g. 8, [2,3,5]
// 7, [3,4,7]