package recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(7));

        System.out.println();

        System.out.println(factorialTail(5,1));
        System.out.println(factorialTail(6,1));
        System.out.println(factorialTail(7,1));
    }

    public static int factorial(int n){
        if(n == 0 || n ==1)
            return 1;
        return n * factorial(n-1);
    }

    public static int factorialTail(int n, int fact){
        if(n == 0  || n ==1)
            return fact;
        fact *= n;
        return factorialTail(n-1, fact);
    }
}
