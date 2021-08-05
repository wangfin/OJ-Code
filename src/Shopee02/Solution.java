package Shopee02;
import java.util.*;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 给定一个简单XML字符串，可能包含XML的嵌套，输入一个路径，输出对应路径的值，如果不存在则返回空字符串
     *
     * @param inxml string字符串 xml字符串
     * @param path string字符串 取值路径
     * @return string字符串
     *
     * 简单的想法是使用字符串进行匹配，构建一个stack来存储值
     * 然后构建一个map，key是前面的路径，value就是里面的值
     * "<people><name>shopee</name></people>","people.name"
     */
    public String GetXMLValue(String inxml, String path) {
        // write code here
        // 构建一个stack来匹配字符
        Deque<String> queue = new LinkedList<String>();
        // 在构建一个Map，用来保存value
        HashMap map = new HashMap();
        // 如果遇到<表示入栈，>表示入栈结束
        // 如果遇到<\表示出栈，>表示出栈结束
        StringBuffer nameBuf = new StringBuffer();
        StringBuffer valBuf = new StringBuffer();
        // 开始遍历
        for (int i = 0; i < inxml.length(); i++){
            // 表示入栈开始
            if (inxml.charAt(i) == '<'){
                // 入栈之前，保存value
                if (valBuf != null){
                    String val = valBuf.toString();
                    String name = "";
                    for (int n_que = 0; n_que < queue.size(); n_que++){
                        name = queue.poll();
                    }

                }


                // 先清空
                nameBuf.delete(0, nameBuf.length());
                valBuf.delete(0, valBuf.length());
                // 往后挪一个
                i++;
                // 不是/，入栈
                if (inxml.charAt(i) != '/') {

                    // 一直到'>'，入栈结束
                    while (inxml.charAt(i) != '>') {
                        // 获取字符串
                        nameBuf.append(inxml.charAt(i));
                        i++;
                    }
                    String name = nameBuf.toString();
                    queue.addLast(name);
                }else {// inxml.charAt(i+1) == '/'
                    // 出栈
                    i++;
                    StringBuffer strBuf = new StringBuffer();
                    // 一直到'>'
                    while (inxml.charAt(i) != '>') {
                        i++;
                    }
                    // 弹出最后的那个
                    queue.removeLast();
                }
            }else{// inxml.charAt(i) != '<'
                // 保存值
                valBuf.append(inxml.charAt(i));
            }

        }


        return "";
    }

    public static void main(String[] args) {
        String str = "<people><name>shopee</name></people>";
        String path = "people.name";
        String res = new Solution().GetXMLValue(str, path);
    }
}
