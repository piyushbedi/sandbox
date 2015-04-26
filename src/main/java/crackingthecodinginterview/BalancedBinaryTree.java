package crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Piyush on 25/04/15.
 */
public class BalancedBinaryTree {

    private BBTNode<Integer> root;

    public BalancedBinaryTree() {
        this.root = null;
    }

    public BalancedBinaryTree(Integer data) {
        this.root = new BBTNode<Integer>(data, null, null);
    }

    public void insert(Integer data) {
         this.root = insert(data, this.root);
    }

    private BBTNode insert(Integer data, BBTNode root) {
        if (root == null) {
            return new BBTNode<Integer>(data, null, null);
        } else {
            if ((Integer)root.getData() >= data) {
                root.setLeft(insert(data, root.getLeft()));
            } else {
                root.setRight(insert(data, root.getRight()));
            }
        }
        return root;
    }

    public String printInOrder() {
        StringBuilder sb = new StringBuilder();
        List<Integer> flattenedTree = inOrder(new ArrayList<Integer>(), root);
        for (Integer element : flattenedTree) {
            sb.append(element.toString() + ", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length()-2) : sb.toString();
    }
    
    private List<Integer> inOrder(List<Integer> soFar, BBTNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return Arrays.asList((Integer)node.getData());
        }
        return concat(inOrder(soFar, node.getLeft()), Arrays.asList((Integer)node.getData()), inOrder(soFar, node.getRight()));
    }

    private List<Integer> concat (List<Integer>... coll) {
        List<Integer> concatedList = new ArrayList<Integer>();
        for (List<Integer> list : coll) {
            for (Integer item : list) {
                concatedList.add(item);
            }
        }
        return concatedList;
    }

    private class BBTNode<Integer> {
        private Integer data;
        private BBTNode left;
        private BBTNode right;

        private BBTNode(Integer data, BBTNode left, BBTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public BBTNode getLeft() {
            return left;
        }

        public BBTNode getRight() {
            return right;
        }

        public void setLeft(BBTNode left) {
            this.left = left;
        }

        public void setRight(BBTNode right) {
            this.right = right;
        }
    }
}
