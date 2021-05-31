package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuickSort {
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
            quickSort(arr, 0, n-1);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static void quickSort(int arr[], int start, int end){
        if(start < end){
            int pivot = partition(arr, start, end);
            for(int i= 0; i< arr.length; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    // choosing last element as pivot
    public static int partition(int arr[], int start, int end){
        int i=start, j=start;
        int temp;
        while(j < end){
            if(arr[j] <= arr[end]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }

            j++;
        }
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}
