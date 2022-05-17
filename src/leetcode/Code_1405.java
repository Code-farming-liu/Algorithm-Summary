package leetcode;

import java.util.PriorityQueue;

// 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
//
//给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
//
//s 是一个尽可能长的快乐字符串。
//s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
//s 中只含有 'a'、'b' 、'c' 三种字母。
//如果不存在这样的字符串 s ，请返回一个空字符串 ""。
//
// 
//
//示例 1：
//
//输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
//示例 2：
//
//输入：a = 2, b = 2, c = 1
//输出："aabbc"
//示例 3：
//
//输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。
// 
//
//提示：
//
//0 <= a, b, c <= 100
//a + b + c > 0
//
public class Code_1405 {
    // 具体的，可以使用「优先队列（堆）」来实现上述过程，以 （字符编号, 字符剩余数量） 的二元组形式进行存储，构建以 字符剩余数量 排倒序的「大根堆」：
    //
    //起始先将 (0, a)(0,a)、(1, b)(1,b) 和 (2, c)(2,c) 进行入堆（其中 123123 为字符编号，代指 abc，同时规定只有剩余数量大于 00 才能入堆）；
    //每次取出堆顶元素（剩余数量最多的字符），尝试参与答案的构造：
    //不违反连续三个字符相同：则说明当前字符能够追加到当前答案尾部，若追加后还有字符剩余，则更新剩余数量重新入堆；
    //违反连续三个字符相同：说明该字符无法追加到当前答案尾部，此时尝试从堆中取出剩余次数次大的字符（若当前堆为空，说明没有任何合法字符能够追加，直接 break），若次大字符追加后还有字符剩余，则更新剩余数量重新入堆，同时将此前取的最大字符元祖也重新入堆；
    //重复步骤 22，直到所有字符均被消耗，或循环提前结束。
    //
    //作者：AC_OIer
    //链接：https://leetcode-cn.com/problems/longest-happy-string/solution/gong-shui-san-xie-jie-he-you-xian-dui-li-q6fd/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<A1> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        if (a > 0) {
            queue.add(new A1('a', a));
        }
        if (b > 0) {
            queue.add(new A1('b', b));
        }
        if (c > 0) {
            queue.add(new A1('c', c));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            A1 cur = queue.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == cur.c && sb.charAt(n - 2) == cur.c) {
                if (queue.isEmpty()) {
                    break;
                }
                A1 next = queue.poll();
                sb.append(next.c);
                if (--next.count != 0) {
                    queue.offer(next);
                }
                queue.offer(cur);
            } else {
                sb.append(cur.c);
                if (--cur.count != 0) {
                    queue.add(cur);
                }
            }
        }
        return sb.toString();
    }
}

class A1 {
    char c;
    int count;

    public A1(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
