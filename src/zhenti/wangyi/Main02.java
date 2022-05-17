package zhenti.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 疫情逐步缓和后，电影院终于开业了，但是由于当前仍处于疫情期间，应尽量保持人群不聚集的原则。
//所以当小易来电影院选定一排后，尽量需要选择一个远离人群的位置。
//已知由0和1组成的数组表示当前排的座位情况,其中1表示已被选座，0表示空座
//请问小易所选座位和最近人的距离座位数最大是多少？
//有如下假设：至少有一个人已选座，至少有一个空座位，且座位数限制为
//
//输入描述:
//一行由0和1组成的整数数组
//
//
//输出描述:
//仅一行一个整数表示答案
//
//
//输入例子1:
//1 0 0 0 1 0 1
//
//输出例子1:
//2
//
//例子说明1:
//小易第3个座位最合适，则和座位1/座位5的距离为2
//
//输入例子2:
//1 0 1 0 1
//
//输出例子2:
//1
//
//例子说明2:
//小易可以选择第2个座位或者第4个座位，距离为1
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        String str = "0 0 0 0 1";
        core(str);
//        List<String> res = new ArrayList<>();
//        dfs(res, new StringBuilder(), 0);

    }

    public static void core(String str) {
        String[] split = str.split(" ");
        int[] nums = new int[split.length];
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (nums[i] == 1) {
                one.add(i);
            } else {
                zero.add(i);
            }
        }
        int res = 1;
        for (Integer z : zero) {
            int a = findFirst(one, z);
            int b = findEnd(one, z);
            if (a == -1 && b != -1) {
                res = Math.max(res, b - z);
                continue;
            }
            if (a != -1 && b == -1) {
                res = Math.max(res, Math.abs(a - z));
                continue;
            }
            res = Math.max(res, Math.min(z - a, b - z));
        }
        System.out.println(res);
    }


    public static int findFirst(List<Integer> list, int index) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < index) {
                return list.get(i);
            }
        }
        return -1;
    }

    public static int findEnd(List<Integer> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > index) {
                return list.get(i);
            }
        }
        return -1;
    }

    public static void dfs(List<String> res, StringBuilder sb, int index) {
        if (sb.length() == 5) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = index; i < 2; i++) {
            sb.append(i);
            dfs(res, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
