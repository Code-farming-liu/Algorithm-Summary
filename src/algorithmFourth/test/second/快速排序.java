package algorithmFourth.test.second;

/**
 * @ClassName: 快速排序
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/13 17:31
 **/

public class 快速排序 {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, lt++, i++);
            } else if (a[i] > v) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

//    private static void sort(int[] a, int lo, int hi) {
//        if (hi <= lo) {
//            return;
//        }
//        int j = partition(a, lo, hi); // 切分
//        sort(a, lo, j - 1);
//        sort(a, j + 1, hi);
//    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1; //左右扫描指针
        int v = a[lo]; // 切分的元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j); // 将v = a[j]放入正确的位置
        return j; // a[lo .. j - 1] <= a[j] <= a[j + 1 .. hi] 达成
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}