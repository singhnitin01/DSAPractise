package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort {

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
            mergeSort(arr, 0, n-1);
            for(int i= 0; i< n; i++)
                System.out.print(arr[i]+" ");

        }
    }

    public static void mergeSort(int arr[], int start, int end){
        if(start < end){
            int mid = (end + start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end){
        int sizeL = mid - start + 1;
        int sizeR = end - mid;
        int left[] = new int[sizeL];
        int right[] = new int[sizeR];

        for(int i=0; i< sizeL; i++)
            left[i] = arr[start+i];

        for(int i=0; i<sizeR; i++)
            right[i] = arr[mid+1+i];

        int k = start;
        int i=0,j=0;
        while(i<sizeL && j<sizeR){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else
                arr[k++] = right[j++];
        }

        while(i < sizeL)
            arr[k++] = left[i++];
        while(j < sizeR)
            arr[k++] = right[j++];
    }

}
/*
test case:
3
6
9 -8 0 -2 5 3
6
4 5 1 3 2 6
*/
