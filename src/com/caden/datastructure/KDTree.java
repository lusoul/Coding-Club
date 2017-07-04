package com.caden.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 */
public class KDTree {
    public static void main(String[] args) {

        KDTree kdTree = new KDTree();
        kdTree.insert(11, 11);kdTree.insert(2, 21);kdTree.insert(13, 12);kdTree.insert(5, 1);
        kdTree.insert(6, 2);kdTree.insert(9, 10);kdTree.insert(8, 7);kdTree.insert(4, 3);
        printout(kdTree.root);
        System.out.println(kdTree.query(7, 8) + " x=" + kdTree.nearX + " y=" + kdTree.nearY);
        System.out.println(kdTree.query(10, 1) + " x=" + kdTree.nearX + " y=" + kdTree.nearY);

        System.out.println(cal(11,11,10,1));
        System.out.println(cal(2,21,10,1));
        System.out.println(cal(13,12,10,1));
        System.out.println(cal(5,1,10,1));
        System.out.println(cal(4,3,10,1));
        System.out.println(cal(6,2,10,1));
        System.out.println(cal(9,10,10,1));
        System.out.println(cal(8,7,10,1));
    }

    public static void printout(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                System.out.print(cur.x + "-" + cur.y + "  ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }

    class Node {
        double x, y;
        boolean dimension;// true means split by x | , false means split by y -
        Node left, right;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    Node root = null;

    public void insert(double x, double y) {
        if (root == null) {
            root = new Node(x, y);
            root.dimension = true;
            return;
        }
        Node cur = root;
        Node node = new Node(x, y);
        while (cur != null) {
            if (cur.dimension && x > cur.x || !cur.dimension && y > cur.y) {
                if (cur.right == null) {
                    cur.right = node;
                    node.dimension = !cur.dimension;
                    return;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = node;
                    node.dimension = !cur.dimension;
                    return;
                } else {
                    cur = cur.left;
                }
            }
        }
    }

    public double query(double x, double y) {
        if (root == null)
            return 0;
        dist = Integer.MAX_VALUE;
        search(root, x, y);
        return dist;
    }

    double dist = Integer.MAX_VALUE;
    double nearX = 0, nearY = 0;
    private void search(Node root, double x, double y) {
        if (root == null) return;

        boolean goLeft = false, goRight = false;
        if (root.dimension && x < root.x || !root.dimension && y < root.y) {
            search(root.left, x, y);
            goLeft = true;
        } else {
            search(root.right, x, y);
            goRight = true;
        }
        // calculate minimum dist
        double curToTarget = Math.sqrt((root.x - x) * (root.x - x) + (root.y - y) * (root.y - y));
        if (curToTarget < dist) {
            nearX = root.x;
            nearY = root.y;
            dist = curToTarget;
        }
        // judge if crossing
        double crossDist = Math.abs(root.x - x);
        if (dist > crossDist) {
            if (goLeft) {
                helper(root.right, x, y);
            } else if (goRight) {
                helper(root.left, x, y);
            }
        }
    }
    private void helper(Node cur, double x, double y) {
        if (cur == null) return;
        // calculate minimum dist
        double curToTarget = Math.sqrt((cur.x - x) * (cur.x - x) + (cur.y - y) * (cur.y - y));
        if (curToTarget < dist) {
            nearX = root.x;
            nearY = root.y;
            dist = curToTarget;
        }
        // judge if crossing
        double crossDist = Math.abs(cur.x - x);
        if (dist > crossDist) {
            helper(cur.left, x, y);
            helper(cur.right, x, y);
        }
    }

    public static double cal(double x, double y, double x1, double y1) {
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }
}

