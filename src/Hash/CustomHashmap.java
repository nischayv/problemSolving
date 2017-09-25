package Hash;

public class CustomHashmap <V>{

    // Check if size >  max value
    // Possibly store string as something else faster for comparison
    // Allow null or don't allow?? Don't allow, how to deal with it // ig key is null or string length is 0, put at a[0]
    // Non synchronized??
    // bitwise operations instead of modulo???
    // Look at java implementation
    // Convert from bst to avl trees
    // size to be power of 2 always??????

    static class Node<V> {
        String key;
        V value;
        Node<V> left;
        Node<V> right;

        public Node(String key, V value, Node<V> left, Node<V> right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node<V>[] buckets;
    private int size;
    private int items;

    @SuppressWarnings("unchecked")
    public CustomHashmap(int size){
        if (size < 1) {
            throw new IllegalArgumentException("Size should be greater than 1");
        }
        this.size = size;
        buckets = new Node[size];
    }

    public boolean set(String key, V data){
        if(key == null)
            return false;

        Node node = new Node<>(key, data, null, null);
        int hashOfKey = hash(key);

        if(buckets[hashOfKey] == null) {
            buckets[hashOfKey] = node;
            ++items;
            return true;
        } else {
            Node root = buckets[hashOfKey];
            putHelper(root, node);
            return true;
        }

    }

    private void putHelper(Node root, final Node newNode) {
        Node currentNode = root;
        Node parentNode;

        while(true) {
            parentNode = currentNode;

            if(newNode.key.compareTo(currentNode.key) == 0) {
                currentNode.value = newNode.value;
                return;
            }
            else if(newNode.key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.left;
                if(currentNode == null) {
                    parentNode.left = newNode;
                    ++items;
                    return;
                }
            } else {
                currentNode = currentNode.right;
                if(currentNode == null) {
                    parentNode.right = newNode;
                    ++items;
                    return;
                }
            }
        }
    }

    public V get(String key) {
        if(key == null) {
            return null;
        }

        Node node = buckets[hash(key)];

        if(node != null) {
            return getHelper(node, key).value;
        }
        else {
            return null;
        }
    }

    private Node<V> getHelper(Node root, String key) {
        if(key == null) {
            return null;
        }

        while(root != null) {
            if(key.equals(root.key)) {
                return root;
            }
            else if(key.compareTo(root.key) < 0) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return null;
    }

    public boolean delete(String key) {
        if(key == null) {
            return false;
        }

        if(buckets[hash(key)] != null) {
            buckets[hash(key)] = deleteHelper(buckets[hash(key)], key);
            --items;
            return true;
        }
        else {
            return false;
        }
    }

    private Node<V> deleteHelper(Node<V> node, String key) {
        if(node == null) {
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = deleteHelper(node.left, key);
        }
        else if(key.compareTo(node.key) > 0) {
            node.right = deleteHelper(node.right, key);
        }
        else {
            if(node.left != null && node.right != null){
                Node<V> successor = successor(node.right);
                node.value = successor.value;
                node.right = deleteHelper(node.right, successor.key);
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

    public float load() {
        return (float) items/size;
    }

    private Node<V> successor(Node<V> node) {
        if(node != null){
            while(node.left != null){
                node = node.left;
            }
        }
        return node;
    }

    private int hash(String key){
        return Math.abs(key.hashCode()) % size;
    }

    public static void main(String[] args) {

        CustomHashmap map = new CustomHashmap<String>(10);

        //Testing for null
        map.set(null, null);
        System.out.println("Null value is: " + map.get(null));

        map.set("KPCB", "Awesomeness!");
        map.set("Test1", "Test1");
        map.set("Test2", "Test2");
        map.set("Test3", "Test3");
        map.set("Test4", "Test4");

        System.out.println("Test1: " + map.get("Test1"));
        System.out.println("Test2: " + map.get("Test2"));
        System.out.println("Test3: " + map.get("Test3"));
        System.out.println("Test4: " + map.get("Test4"));

        System.out.println("load: " + map.load());

        map.delete("Test2");

        System.out.println("Test2: " + map.get("Test2"));

        System.out.println("load: " + map.load());
    }
}
