package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static ArrayList<String> subsets;

    public static void main(String[] args) {
        System.out.println(AllPossibleStrings("abcd"));
        subSets("abcd", -1, "");
        //powerSet("abc", -1, "");
    }

    public static List<String> AllPossibleStrings(String s)
    {
        subsets = new ArrayList<>();
        generateSubsets(s, 0, "");
        return subsets;
    }

    // using decision/ recursion tree
    public static void generateSubsets(String s, int i, String curr){
        if(i == s.length() ){ // if i has crossed the last index which will be n-1( n = s.length) then print the curr string
            if(!curr.equals("")){
                subsets.add(curr);
                //System.out.println(subsets);
            }
            return;
        }

        generateSubsets(s, i+1, curr); // making a choice to not including the charAt i
        generateSubsets(s, i+1, curr+ s.charAt(i)); // making a choice to include the charAt i
    }

    public static void subSets(String s, int k, String curr){

        if(k == s.length())
            return;

        System.out.print(curr+" ");

        String prev = curr;

        for(int i=k+1; i<s.length(); i++){
            curr = prev;
            subSets(s, i, curr+s.charAt(i));
        }

    }

    static void powerSet(String str, int index,
                         String curr)
    {
        int n = str.length();

        // base case
        if (index == n)
        {
            return;
        }

        // First print current subset
        System.out.println(curr);

        // Try appending remaining characters
        // to current subset
        for (int i = index + 1; i < n; i++)
        {
            curr += str.charAt(i);
            powerSet(str, i, curr);

            // Once all subsets beginning with
            // initial "curr" are printed, remove
            // last character to consider a different
            // prefix of subsets.
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
