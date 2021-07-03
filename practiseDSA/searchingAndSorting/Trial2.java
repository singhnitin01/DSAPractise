package searchingAndSorting;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*class A{
    static void print(){
        System.out.println("A static method");
    }
}

class B extends A{
    static void print(){
        String a;
        System.out.println("B static method");
    }
}*/


class Employee{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this+ "----"+o);
        System.out.println(this.hashCode()+"-------------"+o.hashCode());
        if (this == o) return true;
        System.out.println("goes ahead");
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

public class Trial2 {

    public static void main(String[] args) {

        /*Employee e1 = new Employee(1, "John");
        Employee e2 = new Employee(1, "John");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));*/

        String a = new String("hello");
        String b = "hello";
        String c = "hello";
        String d = new String("hello");
        String e = "hello";
        String f = new String(b);

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(10);

        PriorityQueue pq = new PriorityQueue(list);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == d);
        System.out.println(b == d);
        System.out.println(a == e);
        System.out.println(b == e);
        System.out.println(b == f);
        System.out.println(a == f);
        /*A a = new B();
        a.print();
        B b = new B();
        b.print();
        A a1 = new A();
        a1.print();

        int  n =0;
        try{
            n = n/0;
        }
        finally {
            System.out.println("No Catch. That is try should have either catch or finally or both!");
        }*/
    }
}
