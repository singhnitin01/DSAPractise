package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String[] inp = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inp[0]);
            //int k = Integer.parseInt(inp[1]);

            inp = br.readLine().trim().split(" ");
            int arr[] = new int[n];

            for(int i=0; i < n; i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            insertionSort(arr, n);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static void insertionSort(int arr[], int n){
        for(int i = 1; i< n; i++){
            insert(arr, i);
        }
    }

    public static void insert(int arr[], int i){
        int j = i - 1;
        int val = arr[i];
        while( j >= 0 && arr[j] > val){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = val;
    }
}

// test cases
/*3
6
4 5 1 3 2 6*/
