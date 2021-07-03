package mathAndBitManipulation;

public class TwoMissingNumbers {

    public static void main(String[] args) {
        int missing[] = findTwoMissingNum(new int[]{2, 3, 4, 5});
        System.out.println(missing[0] + "  "+ missing[1]);
    }

    public static long sumLesserThanM(int arr[], long m){
        long sum =0;
        for(int i=0;i<arr.length; i++)
            if(arr[i] < m)
                sum+= (long)arr[i];
        return sum;
    }

    public static long sumGreaterThanM(int arr[], long m){
        long sum =0;
        for(int i=0;i<arr.length; i++)
            if(arr[i] > m)
                sum+= (long)arr[i];
        return sum;
    }

    public static int[] findTwoMissingNum(int[] arr){
        int n = arr.length;
        n+=2;
        long sum = (n * (n+1))/2;

        int ret[] = new int[2];

        for(int i=0; i< arr.length; i++)
            sum -= (long)arr[i];

        long avg = sum /2;

        long first = sumLesserThanM(arr, avg);
        //System.out.println(first);

        ret[0] =(int) (((avg-1) * (avg))/2 - first);

        long last = sumGreaterThanM(arr, avg);
        //System.out.println(last);

        long sumGreater = (long)(n * (n+1))/2 - (avg * (avg +1))/2;
        ret[1] = (int)(sumGreater - last);

        return ret;
    }


    public static int[] findTwoMissingNumXOR(int []arr){
        int[] ret = new int[2];

        int missing = 0;

        for(int i=0; i< arr.length; i++)
            missing ^= arr[i];

        for(int i = 1; i<= arr.length+2; i++)
            missing ^= i;

        int temp = missing;
        int set = 0;
        while(temp %2 == 1){
            set++;
            temp = temp >> 1;
        }

        int setTot = 0, unsetTot = 0;
        for(int i = 0; i< arr.length; i++){
            temp = arr[i] >> set;
            if(temp %2 == 1)
                setTot ^= arr[i];
            else unsetTot ^= arr[i];
        }

        for(int i = 1; i<= arr.length+2; i++){
            temp = i >> set;
            if(temp %2 == 1)
                setTot ^= i;
            else unsetTot ^= i;
        }
        ret[0] = setTot;
        ret[1] = unsetTot;
        return ret;
    }
}
