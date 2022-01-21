package BST;

public class BSTExample {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.print();
        System.out.println(tree.search(40));
    }

}


class BST {
    Node root;

    public void insert(int key) {
        root = insertRec(root, key);

    }

    public Node insertRec(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node node, int key) {
        Node result = null;
        if (node == null)
            return null;
        if (node.key == key)
            result = node;
        else if (key < node.key)
            result = searchRec(node.left, key);
        else if (key > node.key)
            result = searchRec(node.right, key);
        return result;
    }

    private Node searchRec2(Node node, int key) {
        Node result = null;
        if (node == null)
            return null;
        if (key < node.key)
            node.left = searchRec(node.left, key);
        else if (key > node.key)
            node.right = searchRec(node.right, key);
        else {
            result = node;
        }
        return result;
    }

    public void print() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print("-> " + node.key);
        printInOrder(node.right);
    }
}


class Node {
    int key;
    Node left, right;

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(int key) {
        this.key = key;
    }
}
