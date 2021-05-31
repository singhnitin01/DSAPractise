package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountinSort {
    public static void main(String[] args) throws Exception{
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
            arr = countingSort(arr);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static int[] countingSort(int []arr){
        int max = arr[0], n = arr.length;
        int output[] = new int[n];

        for(int i=0; i<n; i++){
            if(arr[i] > max)
                max = arr[i];
        }

        int count[] = new int[max+1];

        for(int i= 0; i<n; i++)
            count[arr[i]]++;

        for(int i=1; i< count.length; i++)
            count[i] += count[i-1]; //  this makes it stable

        for(int i=0; i<n; i++){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }
}
