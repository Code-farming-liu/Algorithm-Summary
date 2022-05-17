package zhousai;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName: Main02
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/8/29 10:56
 **/

public class Main02 {
    public static void main(String[] args) {
        String[] str = {"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};
        kthLargestNumber(str, 3);
//        System.out.println("20".compareTo("22"));
    }
    public static String kthLargestNumber(String[] nums, int k) {
        int length = nums.length;
        PriorityQueue<BigInteger> queue = new PriorityQueue<>((t1, t2) -> t1.compareTo(t2));
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            BigInteger temp = help(nums[i]);
            if (queue.size() < k) {
                queue.offer(temp);
            } else {
                if (queue.peek().compareTo(temp) < 0) {
                    queue.poll();
                    queue.offer(temp);
                }
            }
        }
        return queue.peek() + "";
    }
    public static BigInteger help (String str) {
        BigInteger res = new BigInteger("0");
        for (int i = 0; i < str.length(); i++) {
            res = res.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf((str.charAt(i) - '0')));
        }
        return res;
    }
}
