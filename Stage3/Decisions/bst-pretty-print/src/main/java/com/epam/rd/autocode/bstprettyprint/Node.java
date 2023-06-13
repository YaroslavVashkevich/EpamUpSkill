package com.epam.rd.autocode.bstprettyprint;

public class Node {
    int value;
    Node leftChild;
    Node rightChild;
    Node parent;
    int height;

    int length;

    public Node(int value) {
        this.value = value;
    }

    public void addNode(int i, Node node, int length) {
        if (i < node.value && node.leftChild == null) {
            Node child = new Node(i);
            child.length = String.valueOf(node.value).length() + length;
            node.leftChild = child;
            node.leftChild.parent = node;
        } else if (i > node.value && node.rightChild == null) {
            Node child = new Node(i);
            child.length = String.valueOf(node.value).length() + length;
            node.rightChild = child;
            node.rightChild.parent = node;
        } else if (i < node.value) {
            int left = String.valueOf(node.value).length() + length + 1;
            addNode(i, node.leftChild, left);
        } else if (i > node.value) {
            int right = String.valueOf(node.value).length() + length + 1;
            addNode(i, node.rightChild, right);
        }

    }

    public String parent(Node node) {
        if (node.rightChild != null && node.leftChild != null) {
            return "┤";
        } else if (node.rightChild == null && node.leftChild != null) {
            return "┘";
        } else if (node.rightChild != null) {
            return "┐";
        } else return "";
    }

    public String child(Node child) {
        if (child == null) {
            return "";
        } else if (child.parent == null) {
            return "";
        } else if (child.parent.leftChild != null && child.parent.leftChild.equals(child)) {
            return "┌";
        } else if (child.parent.rightChild != null && child.parent.rightChild.equals(child)) {
            return "└";
        } else return "";
    }

    @Override
    public String toString() {
        return " ".repeat(length) + child(this)
                + value + parent(this);
    }

}
