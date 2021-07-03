package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while(tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            int sum = Integer.parseInt(br.readLine().trim());
            String inp[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for(int i=0; i < n; i++)
                arr[i] = Integer.parseInt(inp[i]);

            System.out.println("Total Subsets: "+ subsetSum(arr, sum, 0));
            System.out.println("Total Subsets using Choice Tree: "+subSetSumChoiceTree(arr, sum, arr.length-1));
        }
    }

    public static int subsetSum(int arr[], int sum, int k){
        if(sum < 0)
            return 0;
        if(sum == 0)
            return 1;

        int subsets = 0;

        for(int i=k; i< arr.length; i++){
            int ret = subsetSum(arr, sum - arr[i], i+1);
            subsets+= ret;
        }
        return subsets;
    }

    // using decision tree
    public static int subSetSumChoiceTree(int arr[], int sum, int n){
        if(n<0){
            if(sum == 0)
                return 1;
            return 0;
        }
        return subSetSumChoiceTree(arr, sum, n-1)  + subSetSumChoiceTree(arr, sum - arr[n], n-1);
    }
}
/*
e.g.
3
25
10 20 15
1

5
8
10 5 2 3 6
2

*/
