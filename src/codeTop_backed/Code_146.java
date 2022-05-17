package codeTop_backed;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code_146
 * @Description: LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * @Author: Admin
 **/

public class Code_146 {
    public static class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList next;
        DoubleLinkedList pre;

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoubleLinkedList() {
        }
    }

    Map<Integer, DoubleLinkedList> map = new HashMap<>();
    int size = 0;
    DoubleLinkedList head = null;
    DoubleLinkedList tail = null;
    int capacity = 0;

    public Code_146(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkedList node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = map.get(key);
        if (node == null) {
            DoubleLinkedList temp = new DoubleLinkedList(key, value);
            addHead(temp);
            map.put(key, temp);
            size++;
            if (size > capacity) {
                DoubleLinkedList tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            map.put(key, node);
            moveToHead(node);
        }
    }

        // 添加到队首
    public void addHead(DoubleLinkedList node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    // 移除一个元素
    public void removeNode(DoubleLinkedList node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    // 移除一个元素到队首
    public void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addHead(node);
    }

    // 移除队尾的元素
    public DoubleLinkedList removeTail() {
        DoubleLinkedList tail = this.tail.pre;
        DoubleLinkedList res = tail;
        removeNode(tail);
        return res;
    }
}

class Test {
    public static String add(Object o,String tableName) throws Exception {
        // 获取类的class
        Class c = o.getClass();
        // 反射获取全部属性
        Field[] fs = c.getDeclaredFields();
        // 拼接一个sql
        StringBuffer sql = new StringBuffer();
        sql.append("insert into " + tableName);
        // 要插入的字段
        StringBuffer sql_name = new StringBuffer();
        // 要插入字段的值
        StringBuffer sql_value = new StringBuffer();
        // 遍历
        for (Field f : fs) {
            // 打破private限制
            f.setAccessible(true);
            String fieldName = f.getName();
            // 不用插入id列
            if ("id".equals(fieldName)) {
                continue;
                // 不用插入序列化版本号 serialVersionUID
            }else if("serialVersionUID".equals(fieldName)){
                continue;
            } else {
                // 如果属性是String类型的
                if (f.getType().getSimpleName().equals("String")) {
                    // 属性名小写
                    sql_name.append(fieldName.toLowerCase() + ",");
                    // 对应的属性值
                    String fd="";
                    // 如果有值 获取值 否则直接加入''
                    if(f.get(o)!=null){
                        // 获取值
                        fd = (String) f.get(o);
                    }
                    // 添加值
                    sql_value.append("\'" + fd + "\'" + ",");
                } else {
                    // 其他类型
                    // 属性名小写
                    sql_name.append(f.getName().toLowerCase() + ",");
                    // 添加值
                    sql_value.append(f.get(o) + ",");
                }
            }
        }
        // 去除多拼接的 ,
        String names = sql_name.toString().substring(0, sql_name.length() - 1);
        // 去除多拼接的 ,
        String values = sql_value.toString().substring(0,sql_value.length() - 1);
        // 拼接sql语句
        sql.append("(" + names + ")").append(" ").append("values(").append(values).append(");");
        System.out.println(sql.toString());
        return sql.toString();
    }

    public static void main(String[] args) throws Exception {
        add(new Student(), "test");
    }
}

class Student {
    private String name = "zhangsan";
    private Integer uid = 1;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
