package searchingAndSorting;

public class LeastGreatertElementOnRight {

    static class Node
    {
        int data;
        Node left, right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static Node successor;

    public static Node insert(Node node, int val){
        if(node == null)
            node = new Node(val);

        else if(val < node.data ){
            successor = node;
            node.left = insert(node.left, val);
        }

        else
            node.right = insert(node.right, val);

        return node;
    }

    public static void main(String[] args) {
        int []arr = new int[]{8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28};

        Node root = null;

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        for(int i = arr.length-1; i >= 0; i--){
            successor = null;


            root = insert(root, arr[i]);

            if(successor != null)
                arr[i] = successor.data;
            else arr[i] = -1;
        }

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
