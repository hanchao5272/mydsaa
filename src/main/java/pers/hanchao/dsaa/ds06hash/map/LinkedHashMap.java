package pers.hanchao.dsaa.ds06hash.map;

import org.apache.commons.lang3.RandomUtils;

/**
 * 链地址法-实现的哈希表
 */
public class LinkedHashMap {
    //哈希表
    private SortedLinkedList[] hashArray;
    //容量
    private int capacity;

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        hashArray = new SortedLinkedList[this.capacity];
        //对每个链表继续初始化
        for (int i = 0; i < capacity; i++) {
            hashArray[i] = new SortedLinkedList();
        }
    }

    /**
     * 定义哈希表
     */
    public void display() {
        System.out.println("================== hashmap ==================");
        for (SortedLinkedList linkedList : hashArray) {
            linkedList.display();
        }
        System.out.println("================== end  ==================");
    }

    /**
     * 哈希算法
     *
     * @param key
     * @return
     */
    public int hash(int key) {
        return key % capacity;
    }

    /**
     * 插入
     *
     * @param node
     */
    public void insert(Node node) {
        int key = node.getKey();
        int hashValue = hash(key);
        hashArray[hashValue].insert(node);
    }

    /**
     * 删除key的节点
     *
     * @param key
     * @return
     */
    public Node delete(int key) {
        int hashValue = hash(key);
        Node tempNode = find(key);
        hashArray[hashValue].delete(key);
        return tempNode;
    }

    /**
     * 查找key的节点
     *
     * @param key
     * @return
     */
    private Node find(int key) {
        int hashValue = hash(key);
        return hashArray[hashValue].find(key);
    }

    /**
     * <p>测试</p>
     *
     * @author hanchao 2018/5/13 20:30
     **/
    public static void main(String[] args) {
        LinkedHashMap hashMap = new LinkedHashMap(10);
        hashMap.display();
        //插入
        for (int i = 0; i < 20; i++) {
            hashMap.insert(new Node(RandomUtils.nextInt(10, 1000), RandomUtils.nextInt(1000, 10001000)));
            hashMap.display();
        }
    }
}
