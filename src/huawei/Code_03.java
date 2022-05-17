package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 按身高和体重排队
 * 题目描述：
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，
 * 按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述：
 * 两个序列，每个序列由 n 个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述：
 * 排列结果，每个数值都是原始序列中的学生编号，编号从 1 开始
 * 示例 1
 * 输入：
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出：2134
 */
public class Code_03 {
    static class Student {
        int id = 0;
        int height = 0;
        int weight = 0;
    }

    public static void main(String[] args) {
        int num = 3;
        int[] height = {90, 110, 90};
        int[] weight = {45, 60, 45};
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Student student = new Student();
            student.id = i;
            student.height = height[i - 1];
            student.weight = weight[i - 1];
            list.add(student);
        }

        Collections.sort(list, new Comparator<Student>() {
            // 从小到大 o1 - o2  从大到小 o2 - o1
            @Override
            public int compare(Student o1, Student o2) {
                return o1.height == o2.height ? o1.weight- o2.weight : o1.height - o2.height;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).id);
        }
    }
}
