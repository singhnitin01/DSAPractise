package searchingAndSorting;


class Singelton implements Cloneable{
    private static Singelton s;

    private Singelton(){}

    public static Singelton getInstance(){
        if(s== null)
            s = new Singelton();
        return s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class MyThread extends Thread{

}


public class Trial1 {

    public static Boolean isGroup(){
        return null;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Singelton s = Singelton.getInstance();
        Singelton t = (Singelton) s.clone();
        System.out.println(s.hashCode());
        System.out.println(t.hashCode());
        System.out.println();
        print(7);
        System.out.println();
        System.out.println(factorial(5));
    }

    public static void print(int n){
        if(n ==0)
            return;

        System.out.print(n+" ");
        print(n-1);

    }


    public static int factorial(int n ){
        if(n==1)
            return 1;
        return n * factorial(n-1);
    }
}
