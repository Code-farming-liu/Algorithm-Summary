package zuoshendata.zuoshen4.basic.class01;

public class Test02 {
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
        int mid = (left + right) >>> 1;
        sortProcess(arr, left, mid);
        sortProcess(arr, mid + 1, right);
        // 合并
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left, right);
            int[] p = partition(arr, left, right);

        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int start = left - 1;
        int end = right;
        int cur = left;
        while (cur < end) {
            if (arr[cur] < arr[right]) {
                swap(arr, ++start, cur++);
            } else if (arr[cur] > arr[right]) {
                swap(arr, --end, cur);
            } else {
                cur++;
            }
        }
        return new int[]{start + 1, end};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
