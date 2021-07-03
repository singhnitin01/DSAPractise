package Trees;

import java.util.*;

public class ViewsOfTree {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(60);
        node.right.left = new Node(50);

        System.out.println(leftView(node));
        System.out.println(topView(node));
    }

    // intuition: on every level from top to bottom, the leftmost available node should be shown
    // for level order we use queue and for each level(i.e. size of queue on that level) we'll print the first node
    public static ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //Node newLevel = root;
        while(!queue.isEmpty()){

            int n = queue.size();
            Node out;

            for(int i=0; i<n; i++){
                out = queue.remove();
                if(i==0)
                    list.add(out.data);
                if(out.left != null)
                    queue.add(out.left);
                if(out.right != null)
                    queue.add(out.right);
            }
        }
        return list;
        /*ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node newLevel = root;
        while(!queue.isEmpty()){
            Node peek = queue.remove();
            if(peek == newLevel){
                newLevel = null;
                list.add(peek.data);
            }
            if(peek.left != null){
                queue.add(peek.left);
                if(newLevel == null)
                    newLevel = peek.left;
            }
            if(peek.right != null){
                queue.add(peek.right);
                if(newLevel == null)
                    newLevel = peek.right;
            }
        }
        return list;*/
    }

    // intuition: on every level from top to bottom, the rightmost(last) available node should be shown
    // for level order we use queue and for each level(i.e. size of queue on that level) we'll print the last node
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(node == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node removed = null;
            for(int i=0; i< size; i++){
                removed = queue.remove();
                if(removed.left != null)
                    queue.add(removed.left);
                if(removed.right != null)
                    queue.add(removed.right);
            }
            list.add(removed.data);
        }
        return list;
    }

    static class NodeDistance{
        Node node;
        int distance;

        NodeDistance(Node node, int d){
            this.node = node;
            this.distance = d;
        }
    }


    // intuition: show the first come and distant node that's already shown
    // for first come and first shown we can use Queue which will hold the distance from root(0)
    // and for storing the negative to positive distance we can use TreeMap that stores in natural order of Integer
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Queue<NodeDistance> queue = new LinkedList<>();
        TreeMap<Integer, Integer> dist_value = new TreeMap<>();

        queue.add(new NodeDistance(root, 0));

        while(!queue.isEmpty()){
            NodeDistance out = queue.remove();

            // since it's top view so first come first shown will be taken
            if(!dist_value.containsKey(out.distance))
                dist_value.put(out.distance, out.node.data);

            if(out.node.left != null)
                queue.add(new NodeDistance(out.node.left, out.distance -1));

            if(out.node.right != null)
                queue.add(new NodeDistance(out.node.right, out.distance +1));

        }

        for(Integer key : dist_value.keySet())
            res.add(dist_value.get(key));

        return res;
    }
}
