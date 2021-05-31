package binarySearch;

public class NumberOfRotation {

    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60}, 13));
    }

    static int findKRotation(int arr[], int n) {
        int low = 0, high = n-1;

        while(low < high){
            int mid = low+ (high-low)/2;
            if(arr[mid] > arr[mid+1])
                return mid+1;
            else if(arr[mid] > arr[high])
                low = mid +1;
            else high = mid;
        }
        return low;
    }
}
