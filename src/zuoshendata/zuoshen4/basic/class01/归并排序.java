package zuoshendata.zuoshen4.basic.class01;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: 归并排序
 * @Description: 归并排序
 * @Author: Admin
 * @Date 2020/12/12 15:59
 **/

public class 归并排序 {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //求中点位置
        int mid = left + ((right - left) >> 1);
        //排好左部分
        sortProcess(arr, left, mid);
        //排好右部分
        sortProcess(arr, mid + 1, right);
        //合并
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        //生成right 到 left 上长度的数组
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }


        // 其实就是将对应 部分剩余的元素 拷贝到help 数组中
        // 两个必有且只有一个月届
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        // 将help数组中的元素 填回到原来数组
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }



    public static void main(String[] args) {
        int[] res = LogarithmArray.generateRandomArray(10, 100);
        LogarithmArray.printArray(res);
        System.out.println();
        mergeSort(res);
        System.out.println();
        LogarithmArray.printArray(res);

//        LogarithmArray.logarithmArray();

    }

}