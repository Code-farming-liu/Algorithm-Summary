package leetcode;

/**
 *  一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 */
public class Code__1185 {
    static String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String dayOfTheWeek(int day, int month, int year) {
        int countDay = 4;
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0 )) {
                countDay += 366;
                continue;
            }
            countDay += 365;
        }

        for (int i = 1; i < month; i++) {
            countDay += days[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                countDay++;
            }
        }
        countDay += day;
        return week[countDay % 7];
    }

        public static void main(String[] args) {
        System.out.println(dayOfTheWeek(29, 2, 2000));
    }
}
