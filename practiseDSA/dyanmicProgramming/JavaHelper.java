package dyanmicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class JavaHelper {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> inList = new ArrayList<>();
        inList.add("abc");
        inList.add("xyz");
        inList.add("pqr");

        list.add(inList);

        inList = new ArrayList<>();
        inList.add("purp");
        inList.add("le");
        inList.add("ur");



        list.add(inList);
        System.out.println(list);
        inList = inList.stream().map(x -> x=x.substring(1)).collect(Collectors.toList());
        System.out.println(inList);

        list.stream().map(x -> x.add("a")).collect(Collectors.toList());

        System.out.println(list);
    }
}
