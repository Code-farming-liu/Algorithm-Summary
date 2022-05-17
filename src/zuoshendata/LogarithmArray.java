package zuoshendata;


import zuoshendata.class01.SelectSort;
import zuoshendata.zuoshen4.basic.class01.BubbleSort;
import zuoshendata.zuoshen4.basic.class02.HeapSort;

import java.util.Arrays;

/**
 * @ClassName: LogarithmArray
 * @Description: 数组对数器的类
 * @Author: Admin
 * @Date 2020/12/12 14:34
 **/

public class LogarithmArray {
    public static void logarithmArray() {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            BubbleSort.bubbleSortTest(arr1);
//            SelectSort.selectionSort(arr1);
//            堆排序.heapSort(arr1);
            HeapSort.heapSort(arr1);
//            QuickSort.quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                System.out.println();
                System.out.println("绝对正确的");
                printArray(arr2);
                System.out.println();
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        BubbleSort.bubbleSortTest(arr);
        SelectSort.selectionSort(arr);
        System.out.println();
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        boolean flag = (arr1 == null && arr2 != null) || (arr1 != null && arr2 == null);
        if (flag) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 绝对正确的方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //生成长度随机的数组
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }
}