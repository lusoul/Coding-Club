package com.caden.leetcode.amazon.OA;

import java.util.*;

/**
 * 给出一个ArrayList<Connection>，里面是Connection类(edge两端的城市名和它们之间的一个cost)，
 * 要求找出一些边，把所有城市连接起来并且总花费最小。不能有环，最后所以城市要连成一个连通块。
 * 不能的话输出空表或者null(这个不太记得，题目有说，有占一个case)，最后还要按城市名字(先node1，node1相同按node2)排序输出。
 * 这题我用了union find + kruskal的做法，可以上网查一下，网上类似的资料很多，我也是网上参考的。
 class Connection {
     String node1;
     String node2;
     int cost;
 }
 输入:
 ("Acity","Bcity",1}
 ("Acity","Ccity",2}
 ("Bcity","Ccity",3}
 输出：
 ("Acity","Bcity",1}
 ("Acity","Ccity",2}
 */
public class CityConnectionMST {
    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        if (connections == null || connections.size() == 0) return new ArrayList<>();
        //先排序，让花费小的路径放在前面
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        ArrayList<Connection> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        //将所有城市放到set中，这个set用于UnionFind的初始化
        for (Connection connection : connections) {
            String city1 = connection.city1;
            String city2 = connection.city2;
            set.add(city1);
            set.add(city2);
        }

        UnionFind uf = new UnionFind(set);//每个城市初始父亲是自身

        for (Connection connection : connections) {
            String city1 = connection.city1;
            String city2 = connection.city2;
            if (!uf.find(city1).equals(uf.find(city2))) {//如果两个城市不是联通的，就将他两连起来
                uf.union(city1, city2);
                res.add(connection);
            }
        }

        if (set.size() - 1 != res.size()) return new ArrayList<>();//res中放的是相连后边的个数，应该是所有城市个数-1。否则说明有城市没联通或者有环，不合法

        //因为最后输出要求按城市字母顺序输出，所以排序下
        Collections.sort(res, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.city1.equals(o2.city2)) {
                    return o1.city2.compareTo(o2.city2);
                }
                return o1.city1.compareTo(o2.city1);
            }
        });

        return res;

    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 1));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 1));

        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res) {
            System.out.println(c.city1 + " -> " + c.city2 + " 需要花费大洋 : " + c.cost);
        }
    }
}

class Connection {
    String city1;
    String city2;
    int cost;

    public Connection(String a, String b, int c) {
        city1 = a;
        city2 = b;
        cost = c;
    }
}

class UnionFind {
    HashMap<String, String> parent;//key为城市的名字，value为城市的父亲城市名字

    public UnionFind(HashSet<String> set) {
        parent = new HashMap<>();
        for (String s : set) {
            parent.put(s, s);
        }
    }

    public String find(String p) {
        while (!p.equals(parent.get(p))) {
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }

    public void union(String p, String q) {
        String rootP = find(p);
        String rootQ = find(q);
        if (rootP.equals(rootQ)) return;
        parent.put(rootP, rootQ);
    }
}