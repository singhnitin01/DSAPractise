package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionSort {
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
            selectionSort(arr, n);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static void selectionSort(int arr[], int n){
        for(int i = 0; i < n-1; i++){
            int j = select(arr, i, n);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int select(int arr[], int i, int n ){
        int min = i;
        for(int j = i+1; j<n; j++){
            if(arr[j] < arr[min])
                min = j;
        }
        return min;

    }
}
// test cases
/*3
6
4 5 1 3 2 6*/