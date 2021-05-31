package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort {
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
            bubbleSort(arr);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0; i < n-1; i++){
            boolean swapped  = bubble(arr, i, n);
            for(int j= 0; j< n; j++)
                System.out.print(arr[j]+" ");
            System.out.println();
            if(!swapped)
                break;
        }
    }

    public static boolean bubble(int arr[], int i, int n){
        boolean swapped = false;
        for(int j = 1; j < n-i; j++){
            if(arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                swapped = true;
            }
        }
        return swapped;
    }
}

// test cases
/*3
6
4 5 1 3 2 6*/