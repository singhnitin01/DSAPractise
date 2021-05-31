package recursion;

public class Sum {

    public static void main(String[] args) {

        System.out.println(findSum(4));
        System.out.println(findSumTailRecursion(5, 0));
    }

    public static int findSum(int n){
        if(n==0)
            return 0;
        return n + findSum(n-1);  // this is not tail recursive since it needs to store function variables and counters
    }

    public static int findSumTailRecursion(int n, int sum){
        if(n==0)
            return sum;
        return findSumTailRecursion(n-1, n+sum);
    }

}
