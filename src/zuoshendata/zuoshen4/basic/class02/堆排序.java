package zuoshendata.zuoshen4.basic.class02;


import java.util.LinkedHashMap;

/**
 * @ClassName: 堆排序
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 11:53
 **/

public class 堆排序 {

    // 堆排序
    public static void heapSort(int[] arr) {


        if (arr == null || arr.length < 2) {
            return;
        }
        // 转换成大顶堆(0 ~ i)
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

    // 值变小向下沉
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = (2 * index) + 1;
        while (left < heapSize) {
            // 最大的下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;

            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            // largest != index
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 将数组变成一个大根堆
    public static void headInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
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
//        LogarithmArray.logarithmArray();
        LinkedHashMap<Integer, Integer> linked = new LinkedHashMap<>();
        linked.put(1, 1);
        linked.put(2, 2);
        linked.put(3, 3);
        linked.put(4, 4);
    }
}