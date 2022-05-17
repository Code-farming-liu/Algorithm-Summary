package zuoshendata.zuoshen4.basic.class03;

/**
 * @ClassName: 用数组实现栈
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 19:19
 **/

public class 用数组实现栈 {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(Integer initSize) {
            if (initSize < 0) {
                throw new RuntimeException("初始化长度不能小于0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push (int num) {
            if (size == arr.length) {
                throw new RuntimeException("栈满");
            }
            arr[size++] = num;
        }

        public Integer pop() {
            if (size == 0) {
                throw new RuntimeException("栈为空");
            }
            return arr[--size];
        }
    }

}