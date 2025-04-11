import java.util.ArrayList;

class Node {
    String data;
    ArrayList<Node> node_list;
    Node lChild;
    Node rChild;

    public Node(String D) {
        this.data = D;
        node_list = new ArrayList<>();
    }
}

public class Solution1 {
    /**
     * @param args
     */

    public void deep_first(Node root) {

    }

    public static void preOrder(Node root) {
        System.out.printf(root.data);
        //
        if (root.lChild != null) {
            preOrder(root.lChild);
        }
        if (root.rChild != null) {
            preOrder(root.rChild);
        }
    }

    public static void treePreOrder(Node root) {
        if (root != null) {
            System.out.printf(root.data);
            for (Node n : root.node_list) {
                treePreOrder(n);
            }
        }
        return;
    }
    
    public static void treeAfterOrder(Node root) {
        if (root != null) {
            for (Node n : root.node_list) {
                treeAfterOrder(n);
            }
            System.out.printf(root.data);
        }
        return;
    }


    

    public static void inOrder(Node root) {
        //
        if (root.lChild != null) {
            inOrder(root.lChild);
        }
        System.out.printf(root.data);
        if (root.rChild != null) {
            inOrder(root.rChild);
        }
    }

    public static void afterOrder(Node root) {
        //
        if (root.lChild != null) {
            afterOrder(root.lChild);
        }
        if (root.rChild != null) {
            afterOrder(root.rChild);
        }
        System.out.printf(root.data);
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        /**
         * A
         * / \
         * B C
         * / / \
         * D E F
         * / / \
         * G H I
         */
        A.lChild = B;
        A.rChild = C;

        B.lChild = D;
        C.lChild = E;
        C.rChild = F;

        D.lChild = G;
        E.lChild = H;
        E.rChild = I;

        Solution1.preOrder(A);
        System.out.println("----------");
        Solution1.inOrder(A);
        System.out.println("----------");
        Solution1.afterOrder(A);
        System.out.println("----------");

        /**
         *      A
         *    /   \
         *   B     C
         *  /|\   /
         * D E F G
         *      / \
         *     H   I
         */
        A.node_list.add(B);
        A.node_list.add(C);
        B.node_list.add(D);
        B.node_list.add(E);
        B.node_list.add(F);

        C.node_list.add(G);

        G.node_list.add(H);
        G.node_list.add(I);

        Solution1.treePreOrder(A);
        System.out.println("----------");
        Solution1.treeAfterOrder(A);
        System.out.println("----------");
    }

}
