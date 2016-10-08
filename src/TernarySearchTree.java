public class TernarySearchTree {

    public static void main(String args[]){
        TernarySearchTree x = new TernarySearchTree();
        Tree t = x.new Tree();
        t.insert(7);
        t.insert(7);
        t.insert(3);
        t.insert(0);
        t.insert(2);
        t.print();
    }

    public class Tree{

        private class Node {
            int val;
            Node left = null;
            Node mid = null;
            Node right = null;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node root;



        public void insert(int val) {
            if (root != null) {
                insertHelper(val, root);
            } else {
                root = new Node(val);
            }
        }

        private void insertHelper(int val, Node node) {
            if (val < node.val) {
                if (node.left != null){
                    insertHelper(val, node.left);
                }
                else {
                    node.left = new Node(val);
                }
            }
            else if (val > node.val) {
                if (node.right != null) {
                    insertHelper(val, node.right);
                }
                else {
                    node.right = new Node(val);
                }
            }
            else {
                if (node.mid != null) {
                    insertHelper(val, node.mid);
                }
                else {
                    node.mid = new Node(val);
                }
            }
        }

        public void delete(int val) {
            root = deleteHelper(val, root);
        }

        private Node deleteHelper(int val, Node node) {
            if(node == null) {
                return null;
            }

            if(val < node.val){
                node.left = deleteHelper(val, node.left);
            }
            else if(val > node.val) {
                node.right = deleteHelper(val ,node.right);
            }
            else {
                if(node.mid != null) {
                    node.mid = deleteHelper(val , node.mid);
                }
                else if(node.left != null && node.right !=null){
                    Node successor = successor(node.right);
                    node.val = successor.val;
                    node.right = deleteHelper(successor.val, node.right);
                }
                else{
                    if(node.right != null) {
                        node = node.right;
                    }
                    else {
                        node = node.left;
                    }
                }
            }
            return node;
        }

        private Node successor(Node node) {
            if(node != null){
                while(node.left != null){
                    node = node.left;
                }
            }
            return node;
        }

        public void print() {
            print(root);
        }

        private void print(Node root) {
            if (root != null) {
                System.out.println("Node value : " + root.val);
                print(root.left);
                print(root.mid);
                print(root.right);
            }
        }
    }
}
