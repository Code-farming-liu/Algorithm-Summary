package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test54
 * @Description: 电话号码的字母组合
 * * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * * <p>
 * * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * * <p>
 * * 示例:
 * * <p>
 * * 输入："23"
 * * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @Author: Admin
 **/

public class Code_17 {
    //递归 + 回溯
    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
    //这里也可以用map，用数组可以更节省点内存
    /**
     * @Author: Admin
     * @Description: 方法一： 回溯法
     * 思路描述：
     * 对于对于打印"2345"这样的字符串：
     * 第一次递归就是上图中最下面的方格，然后处理完第一个字符2之后，
     * 将输入的字符改变成"345"并调用第二个递归函数
     * 第二次递归处理3，将字符串改变成"45"后再次递归
     * 第三次递归处理4，将字符串改变成"5"后继续递归
     * 第四次递归处理5，将字符串改变成""后继续递归
     * 最后发现字符串为空了，将结果放到列表中并返回
     * 上面是从函数调用的角度去看的，而每次调用下一层递归时，
     * 都需要将本层的一些处理结果放到一个临时变量中，再传递给下一层，从这个变量层层传递的变化看，
     * 就像一棵树一样，
     * <p>
     * 首先我们利用一个String数组 去存储数字对应的字符串
     * 确定一个结束条件也就是 当前字符串的位置 如果 等于字符串的长度，
     * 那么证明我们遍历结束 例如 ad 之后加入到我们对应的结果集合中
     * 之后我们根据字符串数组的下标去求得当前的数字对应的字符串，将其临时保存在一个字符串中，
     * 之后我们开始利用这个字符串进行组合
     * 我们每次将临时字符串中的字符保留 与后面数字对应的字符串进行拼接组合，
     * 我们用完之后便将对应的字符进行删除，最后的那个 结果集合就是我们想要的答案。
     * @param null
     * @return: null
     */
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations1(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }

    //最终输出结果的list
    List<String> res = new ArrayList<>();

    //递归函数
    void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if (index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        //对应的数组的下标
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < map_string.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(map_string.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+map_string.charAt(i), index+1);
            iterStr(str, letter, index + 1);
            //清除对应的字符
            letter.deleteCharAt(letter.length() - 1);
        }
    }

    //采用队列的方法

    /**
     * @param digits
     * @Author: Admin
     * @Description: 方法二：队列求解
     * 思路描述； 我们将对应的第一个数字的字符放入队列之中，之后我们拿出队列的第一个元素"a"，
     * 跟后一个数字的 字符进行拼接 循环此过程即可。
     * @return: java.util.List<java.lang.String>
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }
}