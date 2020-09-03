import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Test25
 * @Description: 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @Author: Admin
 * @Date 2020/9/3 15:47
 **/

public class Test25 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str != null && str.length() > 0 ){
            help(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;

    }
    //一个辅助函数辅助递归遍历 交换
    public void help(char[] chars,int i, ArrayList<String> list){
        //证明遍历完毕
        if(i == chars.length - 1){
            list.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < chars.length; j++) {
                if(j == i || !set.contains(chars[j])){
                    set.add(chars[j]);
                    swap(chars,i , j);
                    help(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }
    //进行交换
    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}