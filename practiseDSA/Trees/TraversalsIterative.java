package Trees;

import java.util.Stack;

public class TraversalsIterative {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(60);
        node.right.left = new Node(50);
        inorderRecursion(node);
        System.out.println();
        inorderIterative(node);
        System.out.println();
        preorderIterative(node);
        System.out.println();
        postOrderIterative(node);
        System.out.println(Math.random() );
    }

    public static void inorderRecursion(Node root){
        if(root == null)
            return;
        inorderRecursion(root.left);
        System.out.print(root.data+" ");
        inorderRecursion(root.right);
    }

    // maintain stack to store node and it's left child
    // incase it's left child is null, then pop and add it's right child if it's present otherwise pop the stack
    public static void inorderIterative(Node root){
        Stack<Node> stack = new Stack<>();

        Node curr = root.left;
        stack.push(root);

        while(!stack.isEmpty() || curr != null){
            if(curr == null){
                curr = stack.pop();
                System.out.print(curr.data+" ");
                curr = curr.right;
            }
            else{
                stack.push(curr);
                curr = curr.left;
            }
        }
    }


    // intuition: pop stack and first right child (if available) and then left child
    static void preorderIterative(Node root)
    {
        //ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node pop = stack.pop();
            //list.add(pop.data);
            System.out.print(pop.data+" ");
            if(pop.right != null)
                stack.push(pop.right);
            if(pop.left != null)
                stack.push(pop.left);
        }
        //return list;
    }

    // intuition: pop only when both of its children are null or last popped is one of its child
    static void postOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node lastPopped = null;
        while(!stack.isEmpty()){
            Node peek = stack.peek();
            Node left = peek.left;
            Node right = peek.right;
            if((left == null && right == null) || (left != null && left == lastPopped) ||
                    (right != null && right == lastPopped)){
                lastPopped = stack.pop();
                System.out.print(peek.data+" ");
            }
            else{
                if(right!= null)
                    stack.push(right);
                if(left != null)
                    stack.push(left);
            }
        }
    }
}
