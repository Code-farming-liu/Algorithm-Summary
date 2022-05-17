package leetcode;

import java.util.*;

/**
 * @ClassName: Code_721
 * @Description: 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 * @Author: Admin
 **/

public class Code_721 {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        //建立一个 根据邮箱地址到Index的映射
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        //简历一个 根据邮箱地址到户主名字的映射
        Map<String, String> emailToName = new HashMap<String, String>();
        //统计邮箱的个数
        int emailsCount = 0;
        //遍历给出的用户和对应的邮箱地址
        for (List<String> account : accounts) {
            //得到当前遍历账户下的户主名字
            String name = account.get(0);
            //得到当前遍历账户下List的长度
            int size = account.size();
            //通过此长度对接下来的邮箱进行遍历
            for (int i = 1; i < size; i++) {
                //得到当前i时的 邮箱地址
                String email = account.get(i);
                //看邮箱对应Index中是否有这个邮箱地址，保证每个邮箱的唯一性
                if (!emailToIndex.containsKey(email)) {
                    //如果没有出现过这个邮箱，将它添加到两个对应的map中
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        //此时两个Map中分别存储了每个邮箱以及它对应的Index，每个邮箱它对应的户主名字。接下来建立并查集
        UnionFind2 uf = new UnionFind2(emailsCount);
        //遍历account
        for (List<String> account : accounts) {
            //得到当前account下第一个邮箱的地址，根据地址得到索引，把它作为根
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            //得到当前account下的邮箱个数进行遍历
            int size = account.size();
            for (int i = 2; i < size; i++) {
                //得到需要进行合并操作的邮箱地址，因为对于同一账户，他们都属于一个人，因此把他们合并
                String nextEmail = account.get(i);
                //根据邮箱地址从映射中取出Index
                int nextIndex = emailToIndex.get(nextEmail);
                //合并操作
                uf.union(firstIndex, nextIndex);
            }
        }
        //通过上面的操作，首先将同一个账户中的每个邮箱指向根邮箱，后续
        //在其他的账户中遇到了相同的邮箱，在接着合并操作，此时对应根节点的个数就是总用户数

        //建立一个Index对应邮箱地址的Map
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        //通过emailToIndex遍历邮箱地址
        for (String email : emailToIndex.keySet()) {
            //根据索引在并查集中得到当前邮箱地址的根节点
            int index = uf.find(emailToIndex.get(email));
            //判断是否存在根节点，没有就创建一个ArrrayList，有的话就获取当前的ArrayList
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            //在当前的List中加入现邮箱地址，因为他们有同一个根
            account.add(email);
            //更新indexToEmails的邮箱列表
            indexToEmails.put(index, account);
        }
        //创建答案表，按要求对答案进行整理
        List<List<String>> merged = new ArrayList<List<String>>();
        //通过indexToEmail的值（values）进行遍历
        for (List<String> emails : indexToEmails.values()) {
            //将emails按照题目要求进行排序
            Collections.sort(emails);
            //得到当前邮箱组的根，然后根据根得到用户名字
            String name = emailToName.get(emails.get(0));
            //创建一个account表
            List<String> account = new ArrayList<String>();
            //首先添加用户名字，然后用addAll将emails表整个添加到account中
            account.add(name);
            account.addAll(emails);
            //最后在答案表中添加整理好后的用户以及邮箱表
            merged.add(account);
        }
        return merged;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("johnsmith@mail.com");
        accounts.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnnybravo@mail.com");
        accounts.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john_newyork@mail.com");
        accounts.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("Mary");
        list3.add("mary@mail.com");
        accounts.add(list3);
        accountsMerge(accounts);
    }
}
class UnionFind2 {
    int[] parent;

    public UnionFind2(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}