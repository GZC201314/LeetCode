package org.gzc.leetcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author GZC
 * @create 2021-05-10 19:42
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors;
    public List<Node> children;
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int val) {
        this.val = val;
        next = null;
        random = null;
        neighbors = new ArrayList<>();
    }
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right) && Objects.equals(next, node.next) && Objects.equals(random, node.random) && Objects.equals(neighbors, node.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next, random, neighbors);
    }
}
