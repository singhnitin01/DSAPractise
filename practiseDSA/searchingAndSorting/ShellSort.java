package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellSort {
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

            shellSort(arr, n);

            for(int i=0; i < n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void shellSort(int []arr, int n){

        for(int gap = n/2; gap >=1; gap /=2){

            for(int i= gap; i< n; i++){

                int temp = arr[i];
                int j = i - gap;

                while(  j >= 0 && arr[j] > temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }

                arr[j+gap] = temp;
            }
        }
    }
}
