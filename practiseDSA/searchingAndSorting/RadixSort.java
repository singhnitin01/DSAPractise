package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RadixSort {
    public static void main(String[] args) throws IOException {
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
            arr = radixSort(arr, n);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static int[] radixSort(int []arr, int n){
        int max = arr[0];
        for(int i= 1; i<n;i++)
            if(arr[i] > max)
                max = arr[i];
        int exp=0;
        while(max != 0){
            int powOfTen = (int)Math.pow(10, exp);
            arr = countingSort(arr, powOfTen, n);
            exp++;
            max /= 10;
        }
        return arr;
    }

    public static int[] countingSort(int []arr, int powOfTen, int n){

        int count[] = new int[10];
        int output[] = new int[n];

        for(int i= 0; i<n; i++)
            count[(arr[i] / powOfTen) % 10]++;

        for(int i= 1; i<10; i++)
            count[i] += count[i-1];


        for(int i = n-1; i>=0; i--){
            output[ count[(arr[i] / powOfTen) % 10] - 1 ] = arr[i];
            count[(arr[i] / powOfTen) % 10]--;
        }
        return output;
    }
}

/*
testCases
3
8
170 45 75 90 802 24 2 66
*/
