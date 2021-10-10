package tongcheng;
import java.util.*;
import java.util.stream.Collectors;

public class Main03 {

    public static void function(char[] s, List<char[]> res) {
        int len = s.length;

        List<List<Character>> result = new ArrayList<>();

        // 数组中已经使用过的数字
        boolean[] used = new boolean[len];
        // 路径列表，保存遍历的排列
        List<Character> path = new ArrayList<>();

        dfs(s, 0, path, used, result);

        for (int i = 0; i < result.size(); i++){
            char[] ss = new char[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++){
                ss[j] = result.get(i).get(j);
            }
            res.add(ss);
        }
    }

    public static void dfs(char[] s, int depth, List<Character> path, boolean[] used, List<List<Character>> res) {
        int len = s.length;
        // 叶子节点，也就是终止条件，nums数组中的元素个数=树的深度
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            // 如果元素没有被使用
            if (!used[i]) {
                // path添加这个路径
                path.add(s[i]);
                // 设置为已经使用
                used[i] = true;

                dfs(s, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<char[]> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            char[] chars = in.next().toCharArray();
            function(chars, list);
            System.out.println(list.stream().map(String::new).collect(Collectors.joining(",")));
        }
    }

}
