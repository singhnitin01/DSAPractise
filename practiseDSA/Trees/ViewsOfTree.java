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
    }

    public static ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
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
        return list;
    }

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
