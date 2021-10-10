package xiaohongshu;

import java.util.*;

public class Solution4 {
    /**
     * 薯队长买了获得了一个遥控机器人。机器人可以接受三种指令： 向前走几步，向左转90度，向右转90度。
     * 这一代的机器上还不具备跨越障碍的能力。机器人在向前的过程中如果遇到障碍或者试图走出边界，则会自动停下。
     * 薯队长把机器人放在一个有障碍的有界网格上，并给机器人发指令。
     * 你需要给出机器人最终所处的位置与初始位置之间的行和列的偏移量。
     * 3 6
     * BBBBBB
     * BRBOBB
     * BBBBOB
     * 6
     * Turn right
     * Forward 3
     * Turn left
     * Forward 2
     * Turn left
     * Forward 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int start_x = 0, start_y = 0;
        // (-1,0)上 (0,1)右 (1,0)下 (0,-1)左
        int[] direction = {-1, 0, 1, 0 ,-1};
        int forward = 0;
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++){
            String s = sc.next();
            char[] ss = s.toCharArray();
            for (int j = 0; j < C; j++){
                map[i][j] = ss[j];
                // 找到初始位置
                if (ss[j] == 'R'){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        int order_num = sc.nextInt();
        String[] orders = new String[order_num+1];
        for (int i = 0; i <= order_num; i++){
            orders[i] = sc.nextLine();
        }
        int now_x = start_x, now_y = start_y;
        // 开始走
        for (int i = 1; i <= order_num; i++){
            String s1 = orders[i].split(" ")[1];
            // 位数为1是移动指令
            if (s1.length() == 1){
                // 移动的格子
                int len = Integer.parseInt(s1);
                for (int l = len; l > 0; l--){
                    now_x += direction[forward];
                    now_y += direction[forward+1];
                    if (now_x >= 0 && now_x <= R && now_y >= 0 && now_y <= C && map[now_x][now_y] != 'O'){
                        continue;
                    }else{
                        now_x -= direction[forward];
                        now_y -= direction[forward+1];
                        break;
                    }
                }


            }else{
                // 转向指令
                if (s1.compareTo("left") == 0) {
                    forward = (4 + (forward - 1)) % 4;
                }else if (s1.compareTo("right") == 0){
                    forward = (4 + (forward + 1)) % 4;
                }

            }
        }

        System.out.println(now_x - start_x);
        System.out.println(now_y - start_y);

    }


}
