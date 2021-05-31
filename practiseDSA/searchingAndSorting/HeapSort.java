package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HeapSort {

    public static int capacity;

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
            capacity = arr.length;
            heapSort(arr);

        }
    }


    public static void heapSort(int []arr){
        formMinHeap(arr);
        int n = arr.length;
        for(int i = 0;i < n; i++)
            System.out.print(deleteMin(arr)+" ");
    }

    public static int deleteMin(int []arr){
        int del = arr[0];
        arr[0] = arr[capacity -1];
        capacity--;
        heapifyDown(arr, 0);
        return del;
    }

    public static void formMinHeap(int []arr){
        int n = arr.length;

        for(int i = n/2; i>=0; i--)
            heapifyDown(arr, i);
    }

    public static void heapifyDown(int []arr, int i){
        int n = capacity;
        if(i == n-1)
            return;
        int smallest = i;
        int c1, c2;
        c1 = 2*i + 1;
        c2 = 2*i + 2;
        if(c1 < n && arr[c1] < arr[smallest])
            smallest = c1;
        if(c2 < n && arr[c2] < arr[smallest])
            smallest = c2;

        if(smallest != i){
            swap(arr, smallest, i);
            heapifyDown(arr, smallest);
        }
        return;
    }

    public static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
