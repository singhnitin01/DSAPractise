package Trees;

public class PruneBT {

      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static TreeNode pruneTree(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node = new TreeNode(0);
        root.right = node;
        node = new TreeNode(1);
        root.right.left = node;
        node = new TreeNode(1);
        root.right.right = node;
        node = new TreeNode(1);
        root.right.right.right = node;
        node = new TreeNode(1);
        root.right.left.right = node;

        inorderTraversal(root);

        root = pruneTree(root);
        System.out.println("done");
        inorderTraversal(root);
    }

    public static void inorderTraversal(TreeNode node){
          if(node == null)
              return;
        inorderTraversal(node.left);
        System.out.print(node.val+" ");
        inorderTraversal(node.right);
    }

}
