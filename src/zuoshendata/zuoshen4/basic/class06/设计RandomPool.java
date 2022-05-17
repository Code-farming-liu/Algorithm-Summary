package zuoshendata.zuoshen4.basic.class06;

import java.util.HashMap;

/**
 * @ClassName: 设计RandomPool
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/17 11:36
 **/

public class 设计RandomPool {
    public static class RandomPool {
        public HashMap<String, Integer> map1 = null;
        public HashMap<Integer, String> map2 = null;
        public int size;

        public RandomPool() {
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            size = 0;
        }

        public void add(String str) {
            if (!this.map1.containsKey(str)) {
                map1.put(str, size);
                map2.put(size, str);
                size++;
            }
        }

        public String getRandom() {
            if(size == 0) {
                return null;
            }
            int index = (int)(Math.random() * size);
            return map2.get(index);
        }

        public void remove(String key) {
            if (this.map1.containsKey(key)) {
                int deleteIndex = this.map1.get(key);
                int lastIndex = --this.size;
                String lastKey = this.map2.get(lastIndex);
                this.map1.put(lastKey, deleteIndex);
                this.map2.put(deleteIndex, lastKey);
                this.map1.remove(key);
                this.map2.remove(lastIndex);
            }
        }

    }
}