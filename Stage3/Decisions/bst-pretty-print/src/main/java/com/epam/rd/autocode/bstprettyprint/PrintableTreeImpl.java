package com.epam.rd.autocode.bstprettyprint;

import java.util.LinkedList;

public class PrintableTreeImpl implements PrintableTree {
    String[] treeString;
    Node root;
    int length = 0;

    @Override
    public void add(int i) {
        if (root == null) {
            root = new Node(i);
        } else root.addNode(i, root, length);
    }

    private void find(Node node) {
        if (node != null) {
            find(node.leftChild);
            node.height = length++;
            find(node.rightChild);
        }
    }

    @Override
    public String prettyPrint() {
        find(root);
        treeString = new String[length];
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.leftChild != null) {
                nodes.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                nodes.offer(node.rightChild);
            }
            treeString[node.height] = node.toString();
        }

        return format(treeString);
    }

    public String format(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].charAt(j) == '┤' || array[i].charAt(j) == '┌' || array[i].charAt(j) == '┐') {
                    int next = i + 1;
                    while (next < array.length && array[next].charAt(j) != '┤' && array[next].charAt(j) != '┘' && array[next].charAt(j) != '└') {
                        StringBuilder sb = new StringBuilder(array[next]);
                        sb.replace(j, j + 1, "│");
                        array[next] = sb.toString();
                        next++;
                    }
                }
            }
            stringBuilder.append(array[i]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
