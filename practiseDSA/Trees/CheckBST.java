package Trees;

//Initial Template for Java
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;


class GfG {

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            BSTTree g = new BSTTree();
            if(g.isBST(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}


// } Driver Code Ends


//User function Template for Java

/*
Structure of Node:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class BSTTree
{
    boolean checkRange(Node node, int min, int max){
        boolean right, left;
        if(node == null)
            return true;
        if(node.data >= min && node.data <= max){
            left = checkRange(node.left, min, node.data);
            if(!left) return false;
            right = checkRange(node.right, node.data+1, max);
            return right;
        }
        else return false;
    }

    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
    {
        return checkRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
/*
2
1 2 3 N N 4 6 N 5 N N 7 N
ans 0
2 1 3
ans 1*/
