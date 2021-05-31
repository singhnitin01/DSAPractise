package binarySearch;

public class SingleElement {
    public static void main(String[] args) {
        System.out.println(search(new int[]{0, 0, 17, 34 ,34}, 5));

    }


    public static int search(int A[], int N)
    {
        int low = 0, high = N-1;

        if(high == 0)
            return A[high];
        else if(A[0] != A[1])
            return A[0];
        else if (A[high] != A[high-1])
            return A[high];


        while(low <= high){
            int mid = low + (high -low)/2;

            if(  A[mid] != A[mid-1] && A[mid] != A[mid+1])
                return A[mid];

            else if ((mid % 2 == 1  &&  A[mid] == A[mid-1]) ||
                    (mid % 2 == 0  &&  A[mid] == A[mid+1])){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}
