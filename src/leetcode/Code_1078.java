package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_1078
 * @Description: Bigram分词
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 *
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 *
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 * @Author: Admin
 **/

public class Code_1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] split = text.split(" ");
        int length = split.length;
        for (int i = 1; i < split.length; i++) {
            if (i + 1 < length && split[i].equals(second) && split[i - 1].equals(first)) {
                res.add(split[i + 1]);
            }
        }
        String[] str = new String[res.size()];
        res.toArray(str);
        return str;
    }
}