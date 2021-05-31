package recursion;

import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josephus(7,3));
        System.out.println(josephus(5,3));
        System.out.println(josephus(4,3));
        System.out.println(josephus(4,2));

        List<Integer> person = new LinkedList<>();
        for(int i=1; i<=7; i++){
            person.add(i);
        }
        System.out.println(solve(person, 3, 0));
    }

    public static int josephus(int n, int k){
        if( n == 1)
            return 0;
        return (josephus(n-1, k) + k) % n;
    }


    public static int solve(List<Integer> person, int k, int index){
        if(person.size() == 1)
            return person.get(0);
        index = (index + k-1) % person.size();
        person.remove(index);
        return solve(person, k, index);
    }
}
