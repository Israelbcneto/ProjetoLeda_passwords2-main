package estrutura_dados;

import interfaces.ITwoParamFunction;
import java.util.*;

class AVLNode {
    public String data;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(String data) {
        this.data = data;
        this.height = 1;
    }
}

public class AVLTree {
    public AVLNode root;
    public ITwoParamFunction<String, String, Integer> comparaTo;

    public AVLTree(ITwoParamFunction<String, String, Integer> comparaTo) {
        this.comparaTo = comparaTo;
        this.root = null;
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(String data) {
        root = insert(root, data);
    }

    private AVLNode insert(AVLNode node, String data) {
        if (node == null) {
            return new AVLNode(data);
        }

        int comparisonResult = comparaTo.apply(data, node.data);

        if (comparisonResult < 0) {
            node.left = insert(node.left, data);
        } else if (comparisonResult > 0) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalanceFactor(node);

        if (balance > 1 && comparaTo.apply(data, node.left.data) < 0) {
            return rotateRight(node);
        }

        if (balance < -1 && comparaTo.apply(data, node.right.data) > 0) {
            return rotateLeft(node);
        }

        if (balance > 1 && comparaTo.apply(data, node.left.data) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && comparaTo.apply(data, node.right.data) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public String[] inOrderAscending() {
        List<String> result = new ArrayList<>();
        inOrderAscending(root, result);
        return result.toArray(new String[0]);
    }

    private void inOrderAscending(AVLNode node, List<String> result) {
        if (node == null) return;
        inOrderAscending(node.left, result);
        result.add(node.data);
        inOrderAscending(node.right, result);
    }

    public String[] inOrderDescending() {
        List<String> result = new ArrayList<>();
        inOrderDescending(root, result);
        return result.toArray(new String[0]);
    }

    private void inOrderDescending(AVLNode node, List<String> result) {
        if (node == null) {
            return;
        }
        inOrderDescending(node.right, result);
        result.add(node.data);
        inOrderDescending(node.left, result);
    }


    public void insertAll(String[] data) {
        for (String value : data) {
            insert(value);
        }
    }

}
