package zuoshendata.zuoshen4.basic.class02;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: 堆排序
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 11:53
 **/

public class HeapSort {

    // 堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 转换成小顶堆(0 ~ i)
        for (int i = 0; i < arr.length; i++) {
            headInsert(arr, i);
        }
        // 堆的容量
        int heapSize = arr.length;
        // 将堆顶的元素 与最后一个数进行交换
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 值变大向下沉
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = (2 * index) + 1;
        while (left < heapSize) {
            // 最小的下标
            int smallest = left + 1 < heapSize && arr[left + 1] < arr[left]
                    ? left + 1
                    : left;

            smallest = arr[smallest] > arr[index] ? smallest : index;
            if (smallest == index) {
                break;
            }
            // smallest != index
            swap(arr, smallest, index);
            index = smallest;
            left = index * 2 + 1;
        }
    }

    // 将数组变成一个小根堆
    public static void headInsert(int[] arr, int index) {
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = LogarithmArray.generateRandomArray(10, 100);
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort(arr1);
        for (int num : arr1) {
            System.out.print(num + " ");
        }
    }
}