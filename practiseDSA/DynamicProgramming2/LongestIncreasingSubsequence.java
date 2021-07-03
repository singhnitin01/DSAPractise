package DynamicProgramming2;

import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = new int[]{4, 10, 6, 5, 8, 11, 2, 20};
                //{10, 5, 18, 7, 2, 9};
                //
        // {3, 4, 2, 8, 10}

        System.out.println(longestIncreasingSubsequence(arr, arr.length));
        System.out.println(longestSubsequenceBS(arr, arr.length));
    }

    public static int longestIncreasingSubsequence(int[] arr, int n){

       int lis[] = new int[n];

       int max = Integer.MIN_VALUE;

       for(int i=0; i<n; i++){
           lis[i] = 1;
           for(int j =0; j < i; j++){
               if(arr[i] > arr[j])
                   lis[i] = Math.max(lis[j]+1, lis[i]);
           }

           max = Math.max(max, lis[i]);
       }

       return max;
    }

    static int longestSubsequenceBS( int arr[], int n)
    {

        if(n ==0)
            return 0;

        int lis[] = new int[n];

        List<Integer> tail = new ArrayList<>();

        tail.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(arr[i] > tail.get(tail.size()-1))
                tail.add(arr[i]);
            else
                replace(tail, arr[i]);
        }
        return tail.size();
    }

    // uses binary search
    static void replace(List<Integer> tail, int key){
        int l =0, h = tail.size()-1;

        //finds ceiling for the key and replaces with it
        while( l < h){
            int mid = l +(h-l)/2;

            if(tail.get(mid) < key)
                l = mid+1;
            else
                h = mid;
        }

        tail.set(l, key);
    }
}
