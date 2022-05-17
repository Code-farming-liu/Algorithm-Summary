package zuoshendata.zuoshen4.basic.class03;

/**
 * @ClassName: 用数组实现队列
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 19:39
 **/

public class 用数组实现队列 {
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer start;
        private Integer end;
        private Integer size;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("初始化参数不能小于 0");
            }
            arr = new Integer[initSize];
            start = 0;
            end = 0;
            start = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("栈满");
            }
            arr[end] = num;
            end = end == arr.length - 1 ? 0 : end++;
            size++;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("栈空");
            }
            size--;
            int res = arr[start];
            start = start == arr.length - 1 ? 0 : start++;
            return res;
        }
    }
}