package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Practise2 {

    int a =10;

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(rand.nextInt(10-5));
        System.out.println(((Math.random() * (10 - 5)) + 5));

        String a = "abcd";
        System.out.println("dhd"+ a.charAt(2));
        char[] z= a.toCharArray();
        System.out.println(z[2]);

        System.out.println(0 %2);
        List<String> repository = new ArrayList<>();
        repository.add("money");
        repository.add("mouse");
        PriorityQueue<String> queue = new PriorityQueue<>();

        for(int i=0; i<repository.size(); i++)
            queue.offer(repository.get(i));
        System.out.print(queue.poll());

    }
}
