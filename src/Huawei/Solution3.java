package Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        // 找到最长的一组依赖
        Scanner sc = new Scanner(System.in) ;
        // 任务数量
        int n = Integer.parseInt(sc.nextLine());
        // 依赖关系数组
        ArrayList<int[]> depend = new ArrayList<>();
        // 时间
        int[] time = new int[n];
        // 获取n组
        for (int i = 0; i < n; i++){
            // 获取整行
            String s = sc.nextLine();
            // 获取依赖字符串
            String[] ss = s.split(" ");
            // 时间，字符串转换为数字
            time[i] = Integer.parseInt(ss[1]);
            // 有多个依赖
            if (ss[0].length() != 1) {
                // 将依赖关系的字符串数组转换为数字数组
                int[] deps = Arrays.asList(ss[0].split(",")).stream().mapToInt(Integer::parseInt).toArray();
                depend.add(deps);
            }
            else{
                depend.add(new int[]{Integer.parseInt(ss[0])});
            }

        }

        // 输出总时长
        int restime = 0;
        for (int i = 0; i < n; i++){
            int tasktime = 0;
            // 如果没有依赖关系
            if (depend.get(i)[0] == -1){
                // 加入时间对比
                if (time[i] > restime){
                    restime = time[i];
                }
            }else{
                // 去遍历依赖关系
                tasktime = dfs(depend, time, depend.get(i), i, tasktime);
                // 加入时间对比
                if (tasktime > restime){
                    restime = tasktime;
                }
            }
        }

        System.out.println(restime);
    }

    // 输出需要的时间
    public static int dfs(ArrayList<int[]> depend, int[] time, int[] task_spend, int task_index, int tasktime){
        if (task_spend[0] == -1){
            // 将该任务的时间返回
            return time[task_index];
        }
        for (int i = 0; i < task_spend.length; i ++){
            // 如果有依赖，则需要任务时间求和
            tasktime = time[task_index] + dfs(depend, time, depend.get(task_spend[0]), task_spend[0], tasktime);
        }
        return tasktime;
    }


}
