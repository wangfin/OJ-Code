package LeetCode547;

import java.util.HashMap;
import java.util.Map;

class UnionFind {
    /**
     * 并查集
     */
    private Map<Integer,Integer> father;

    public UnionFind() {
        father = new HashMap<Integer,Integer>();
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            father.put(rootX,rootY);
        }
    }

    public int find(int x) {
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        while(x != root){
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;
        }

        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

