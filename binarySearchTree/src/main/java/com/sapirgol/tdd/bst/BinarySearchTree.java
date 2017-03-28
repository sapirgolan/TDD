package com.sapirgol.tdd.bst;

/**
 * Created by I062070 on 28/03/2017.
 */
public class BinarySearchTree<Value extends Comparable<Value>> {

    private class Node {
        private Value value;
        private Node left;
        private Node right;

        public Node(Value value) {
            this.value = value;
        }
    }
    private Node root;

    public void put(Value value) {
        root = this.put(root, value);
    }

    private Node put(Node node, Value value) {
        if (node == null) {
            node = new Node(value);
        }
        int compareTo = node.value.compareTo(value);
        if (compareTo > 0) {
            node.left = put(node.left, value);
        }
        if (compareTo < 0) {
            node.right =  put(node.right, value);
        }
        return node;
    }

    public boolean contains(Value searchValue) {
        return contains(root, searchValue);
    }

    private boolean contains(Node node, Value searchValue) {
        if (node == null) {
            return false;
        }

        int compareTo = node.value.compareTo(searchValue);

        if (compareTo == 0) {
            return true;
        }
        if (compareTo > 0) {
            return contains(node.left, searchValue);
        }
        if (compareTo < 0) {
            return contains(node.right, searchValue);
        }
        return false;
    }
}
