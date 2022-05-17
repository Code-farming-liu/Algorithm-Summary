/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/8/4 20:15
 **/

public class Test01 {

    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4"};
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        heapSort(nums);
        int k = 2;
        for (int i = 0; i < k; i++) {
            System.out.println(nums[k]);
        }
//        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        for (int i = 0; i < str.length; i++) {
//            if (smallQueue.size() > k) {
//                smallQueue.poll();
//            }
//            smallQueue.offer(Integer.parseInt(str[i]));
//        }
//        Iterator<Integer> iterator = smallQueue.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
    }

    public static void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        while (heapSize > 0) {
            swap(nums, 0, --heapSize);
            heapIfy(nums, heapSize, 0);
            swap(nums, heapSize--, 0);
        }
    }

    private static void heapIfy(int[] nums, int heapSize, int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int smallest = left + 1 < heapSize && nums[left + 1] < nums[left + 1] ? left + 1 : left;
            index = nums[index] > nums[smallest] ? smallest : index;
            if (index == smallest) {
                break;
            }
            swap(nums, smallest, index);
            index = smallest;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] nums, int index) {
        while (nums[index] < nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}