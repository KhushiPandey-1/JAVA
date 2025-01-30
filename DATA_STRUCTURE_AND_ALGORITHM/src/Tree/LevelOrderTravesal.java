package Tree;

import java.util.*;

public class LevelOrderTravesal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node n = new Node(nodes[idx]);
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }

        public static void levelOrder(Node root) {
//            if(root == null){return;}
//           Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        q.add(null);
//        while(!q.isEmpty()){
//            Node cur = q.poll();
//            if(cur == null){
//                System.out.println();
//                if(q.isEmpty()){
//                    break;
//                }else{
//                    q.add(null);
//                }
//            }else{
//                System.out.print(cur.data+" ");
//                if(cur.left != null){
//                    q.add(cur.left);
//                }
//                if(cur.right != null){
//                    q.add(cur.right);
//                }
//            }
//        }
//    }
               if (root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size(); // Number of nodes at the current level
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    System.out.print(cur.data + " ");
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
                System.out.println(); // New line after each level
            }
        }
        public static int countOfNodes(Node root){
            if(root == null) return 0;
            int left = countOfNodes(root.left);
            int right = countOfNodes(root.right);
            
            return left + right + 1;
        }
     public static int sumOfNodes(Node root){
         if(root == null) return 0;
         int left = sumOfNodes(root.left);
         int right = sumOfNodes(root.right);
         
         return left + right + root.data;
         
     }
     public static int heightOfTree(Node root){
         if(root == null) return 0;
         int left = heightOfTree(root.left);
         int right = heightOfTree(root.right);
         int max = Math.max(left, right) + 1;
         return max;
     }
     static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht,int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }
     public static TreeInfo diameter(Node root){
         if(root == null) return new TreeInfo(0, 0);
         TreeInfo left = diameter(root.left);
//         System.out.println(diameter(root.left));
         TreeInfo right = diameter(root.right);
//          System.out.println(right);
         
         int ht = Math.max(left.ht , right.ht) + 1;
         int dia1 = left.dia;
         int dia2 = right.dia;
         int dia3 = left.ht + right.ht + 1;
         
         int mydia = Math.max(dia3,Math.max(dia1, dia2));
        TreeInfo myinfo = new TreeInfo(ht,mydia);
        return myinfo;
         
     }
     public static int diameterOfTree(Node root){
         if(root == null) return 0;
         int left = diameterOfTree(root.left);
         int right = diameterOfTree(root.right);
         int dia = heightOfTree(root.left) + heightOfTree(root.right) + 1;
         return Math.max(dia, Math.max(left, right));
     }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Tree t = new Tree(); 
        Node root = t.buildTree(nodes);
        System.out.println("Level Order Traversal:");
        Tree.levelOrder(root);
        System.out.println("Count Of Nodes");
        System.out.println(Tree.countOfNodes(root));
        System.out.println("Sum Of Nodes");
        System.out.println(Tree.sumOfNodes(root));
        System.out.println("Height Of Nodes");
        System.out.println(Tree.heightOfTree(root));
        System.out.println("Case 1 Diameter Of Tree");
        System.out.println(Tree.diameterOfTree(root));
         System.out.println("Case 2 Diameter of Tree");
        System.out.println(Tree.diameter(root).dia);
    }
}
