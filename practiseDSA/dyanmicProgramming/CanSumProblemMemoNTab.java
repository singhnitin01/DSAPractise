package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CanSumProblemMemoNTab {

    public static Map<Integer, Boolean> memo;

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
            System.out.println(canSum(targetSum, arr));
            System.out.println(canSumTab(targetSum,arr));
        }
    }

    public static boolean canSum(int targetSum, int[]arr){
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if(targetSum == 0)
            return true;
        if(targetSum < 0)
            return false;


        for(int i = 0; i< arr.length; i++){
            if( canSum(targetSum - arr[i], arr) == true){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }



    public static boolean canSumTab(int target, int arr[]){
        boolean []targetArr = new boolean[target+1];
        targetArr[0] = true;
        for(int i=0; i<= target; i++){
            if(targetArr[i] == true){
                for(int ele : arr){
                    if(i+ ele <= target){
                        targetArr[i+ ele] = true;
                    }
                }
            }
        }
        return targetArr[target];
    }
}
/// e.g. canSum( 300, new int[]{14, 7}) ---> false
// e.g. canSum(7, new int[]{5,3,4,7}) ---> true
// e.g. 8, [2,3,5] ----> true