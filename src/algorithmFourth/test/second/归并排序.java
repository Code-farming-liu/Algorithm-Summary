package algorithmFourth.test.second;

/**
 * @ClassName: Merge
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/13 10:54
 **/

public class 归并排序 {
    private static int[] aux;
    // 自顶向下
//    public static void sort(int[] a) {
//        aux = new int[a.length];
//        sort(a, 0, a.length - 1);
//    }

//    public static void sort(int[] a, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = left + (right - left) / 2;
//        sort(a, left, mid);
//        sort(a, mid + 1, right);
//        merge(a, left, mid, right);
//    }


    public static void sort(int[] a) {
        int length = a.length;
        aux = new int[length];
        for (int sz = 1; sz < length; sz = sz + sz) { // sz子数组的大小
            for (int lo = 0; lo < length - sz; lo += sz + sz) { // lo 子数组的索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            aux[k] = a[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > right) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[i] > aux[j] ? aux[j++] : aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        sort(array);
        for (int number : array) {
            System.out.print(number + "\t");
        }
    }
}