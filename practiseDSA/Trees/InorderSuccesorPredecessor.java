package Trees;

//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class InorderSuccesor {

    static Node buildTree(String str)
    {
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

    public static Node search(Node root,int x){
        if(root==null||root.data==x)
            return root;
        if(root.data>x)
            return search(root.left,x);
        return search(root.right,x);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);

            int k=Integer.parseInt(br.readLine());
            Node kNode = search(root,k);

            Tree g = new Tree();
            Node x = g.inorderSuccessor(root,kNode);


            if(x==null) System.out.print("-1");
            else System.out.print(x.data);

            x = g.inorderPredecessor(root, kNode);

            if(x==null) System.out.println("  -1");
            else System.out.println("  "+x.data);
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Tree
{
    /*public static Node findMin(Node node){
        if(node.left == null)
            return node;
        return findMin(node.left);
    }

    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public Node inorderSuccessor(Node root,Node x)
    {
        if(x.right != null)
            return findMin(x.right);

        Node successor = null;

        while(root != x){
            if(x.data < root.data){
                successor = root;
                root = root.left;
            }
            else root = root.right;
        }
        return successor;
    }
    //above is one solution and below is another approach::::

    */
    public static Node successor = null;

    public static Node predecessor = null;

    public static Node findMin(Node node){
        if(node.left == null)
            return node;
        return findMin(node.left);
    }

    public static void inorderSuccessorUtility(Node root, Node x){
        if(root == null)
            return;
        if(x.data < root.data){
            successor = root;
            inorderSuccessorUtility(root.left, x);
        }
        else if(x.data > root.data)
            inorderSuccessorUtility(root.right, x);
        else
            return;
    }

    public Node inorderSuccessor(Node root,Node x)
    {
        if(x.right != null)
            return findMin(x.right);
        successor = null;
        inorderSuccessorUtility(root, x);
        return successor;
    }

    public Node inorderPredecessor(Node root, Node x){
        if(x.left != null)
            return findMin(x.left);
        predecessor = null;
        inorderPredecessorUtility(root,x);
        return predecessor;
    }
    public void inorderPredecessorUtility(Node node, Node x){
        if(node == null)
            return;
        if(x.data < node.data)
            inorderPredecessorUtility(node.left, x);
        else if(x.data > node.data){
            predecessor = node;
            inorderPredecessorUtility(node.right,x);
        }
        return;
    }
}