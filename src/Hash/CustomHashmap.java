package Hash;

/**
 * A fixed Hashmap that associated String keys with arbitrary objects
 */
public class CustomHashmap <V>{
    /**
     * Max bucket array size to prevent heap space errors
     * Can be increased if needed
     */
    private static final int MAX_ARRAY_SIZE = 1<<30;

    /**
     * Node class to store key and value pairs
     * This is needed because the hashmap is implemented using an Avl tree at each
     * bucket in the array. In the unlikely event that all objects end up in the
     * same bucket, the worse case time will be O(logn)
     */
    static class Node<V> {
        /**
         * String key set by the user
         */
        String key;
        /**
         * Value of type V set by the user
         */
        V value;
        /**
         * Left child of node
         */
        Node<V> left;
        /**
         * Right child of node
         */
        Node<V> right;
        /**
         * Height of tree rooted at current node
         */
        int height;

        /**
         *  Creates a new Node object
         *  @param key String key
         *  @param value V value
         *  @param left Left child of this node
         *  @param right Right child of this node
         */
        public Node(String key, V value, Node<V> left, Node<V> right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            height = 1;
        }
    }

    /**
     * Array of buckets of type Node to store the key values
     */
    private Node<V>[] buckets;
    /**
     * Max size of the hashmap
     */
    private int size;
    /**
     * Actual number of items in the hashmap
     */
    private int items;


    /**
     * Creates a new hashmap
     * @param size Max size of the hashmap
     */

    public CustomHashmap(int size){
        if (size < 1) {
            throw new IllegalArgumentException("Size should be greater than 1");
        }
        // Making the size of the bucket roughly 1.3 times the number of elements
        // This is inorder to maintain a load factor of approximately 0.75 when the hashmap is full
        int capacity = (int) (size * 1.33);
        // To avoid heap exceptions due to very large array sizes
        if (capacity > MAX_ARRAY_SIZE) {
            capacity = MAX_ARRAY_SIZE;
        }

        int bucketSize = 1;
        // Making bucketSize a multiple of 2 >= capacity
        // We do this to allow the use of bitwise AND to find the index, instead of modulo, which is slower
        while (bucketSize < capacity) {
            bucketSize <<= 1;
        }
        this.size = size;
        buckets = new Node[bucketSize];
    }

    /**
     * Set a key value pair
     * @param key String key
     * @param data data of type V to be stored
     * @return boolean value to be returned based on whether insertion was a success
     */
    public boolean set(String key, V data){
        try {
            if (items >= size) {
                throw new Exception("The Hashmap is at max capacity");
            }

            Node<V> node = new Node<>(key, data, null, null);
            int hashOfKey = key == null || key.length() == 0 ? 0 : hash(key);

            if(buckets[hashOfKey] == null) {
                buckets[hashOfKey] = node;
                ++items;
            } else {
                Node<V> root = buckets[hashOfKey];
                buckets[hashOfKey] = setHelper(root, node);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Helper function to create a new key value pair
     * Since an Avl tree is being used, we have to recurse through
     * the nodes when there is a collision to find the right spot
     * to place the node
     * @param node The root node
     * @param newNode The new node that needs to be inserted
     */
    private Node<V> setHelper(Node<V> node, Node<V> newNode) {
        if (node == null){
            ++items;
            return newNode;
        }

        if (newNode.key.compareTo(node.key) < 0) {
            node.left = setHelper(node.left, newNode);
        } else if (newNode.key.compareTo(node.key) > 0) {
            node.right = setHelper(node.right, newNode);
        } else {
            // Key already exists - update the node value
            node.value = newNode.value;
            return node;
        }

        // Balance after insertion
        // As we recurse up after the insertion, we check if any ancestor node is unbalanced and balance it

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left),
                height(node.right));

        // Get the balance factor of this ancestor
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && newNode.key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && newNode.key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && newNode.key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && newNode.key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // return the same node reference
        return node;
    }

    /**
     * Finds the data for the respective key
     * If key doesn't exist, return null
     * @param key String key of the data object we are looking for
     * @return Returns the value if found, otherwise null
     */
    public V get(String key) {
        // If key is null - check index 0 in the bucket
        int hashOfKey = key == null || key.length() == 0 ? 0 : hash(key);
        Node<V> node = buckets[hashOfKey];

        if(node != null) {
            if (key == null || key.length() == 0) {
                return node.value;
            }
            Node<V> newNode = getHelper(node, key);
            return newNode == null ? null : newNode.value;
        }
        else {
            return null;
        }
    }

    /**
     * Helper function to find the key in the AVL tree rooted at a node
     * @param root The root node
     * @param key The key to find
     */
    private Node<V> getHelper(Node<V> root, String key) {
        while(root != null) {
            if(key.compareTo(root.key) == 0) {
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

    /**
     * Deletes the data associated with the respective key
     * @param key The key of the stored data
     */
    public V delete(String key) {
        int hashOfKey = key == null || key.length() == 0 ? 0 : hash(key);
        Node<V> node = buckets[hashOfKey];

        if(node != null) {
            if (hashOfKey == 0){
                // Only storing an element with null key at index 0
                Node<V> deletedNode = buckets[hashOfKey];
                buckets[hashOfKey] = null;
                --items;
                return deletedNode.value;
            }
            // Calls delete helper to recurse through the tree at index hashOfKey
            // and delete the the node with the matching key

            V value = get(key);
            if (value == null) {
                // Key not found
                return null;
            } else {
                buckets[hashOfKey] = deleteHelper(buckets[hashOfKey], key);
                --items;
                return value;
            }
        }
        else {
            // Key not found
            return null;
        }
    }

    /**
     * A helper function to delete a node in an AVL tree rooted at node
     * @param node The root of the AVL tree
     * @param key The key of the stored data
     */
    private Node<V> deleteHelper(Node<V> node, String key) {
        if (node == null) {
         return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = deleteHelper(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteHelper(node.right, key);
        } else {
            // This is the node that needs to be deleted
            // 1 child or children
            if ((node.left == null) || (node.right == null)) {
                Node temp = null;
                if (temp == node.left) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }
                if (temp == null) {
                    temp = node;
                    node = null;
                } else{
                    node = temp;
                }
            } else {
                Node temp = successor(node.right);
                node.key = temp.key;
                node.right = deleteHelper(node.right, temp.key);
            }
        }

        // If the tree had only 1 node, return null
        if (node == null) {
            return null;
        }

        node.height = max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        // Rebalancing the tree if it is unbalanced after a deletion
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }


    /**
     * Returns the load of the hashmap
     * The bucket size is always greater than the actual max number of elements
     * So the load will be never greater 0.75 to avoid collisions and enable fast lookups
     */
    public float load() {
        return (float) items/buckets.length;
    }

    /**
     * Finds the successor of a node in a BST
     * @param node Successor
     */
    private Node<V> successor(Node<V> node) {
        if(node != null){
            while(node.left != null){
                node = node.left;
            }
        }
        return node;
    }

    /**
     * CREDIT: http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/HashMap.java#HashMap.indexFor%28int,int%29
     * Using bitwise AND to find to index to place the element
     * This only works for hashmaps with a size that is a power of 2
     * @param key {String} - String key
     * @return {int} Integer representing the index in the buckets array
     */
    private int hash(String key){
        return (key.hashCode() & (size - 2)) + 1;
    }

    /**
     * Performs right rotation of node in AVL tree
     * @param node The node that needs to be rotated
     */
    private Node<V> rightRotate(Node<V> node) {
        Node<V> x = node.left;
        Node<V> temp = x.right;

        // Perform rotation
        x.right = node;
        node.left = temp;

        // Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // The new root after rotation
        return x;
    }

    /**
     * Performs left rotation of node in AVL tree
     * @param node The node that needs to be rotated
     */
    private Node<V> leftRotate(Node<V> node) {
        Node<V> x = node.right;
        Node<V> temp = x.left;

        // Perform rotation
        x.left = node;
        node.right = temp;

        //  Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    /**
     * Returns the max of two integers
     * @param a Integer 1
     * @param b Integer 2
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Function to find the height of a tree
     * @param node The root of the tree
     */
    private int height(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * Function to find the difference between the left and right subtrees of a node
     * @param node The root of the tree
     */
    private int getBalance(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public static void main(String args[]) {
        CustomHashmap<String> hm = new CustomHashmap<>(10);
        hm.set("KPCB", "KPCB");
        System.out.println(hm.load());
        System.out.println(hm.delete("KPCB"));
        System.out.println(hm.load());
    }
}