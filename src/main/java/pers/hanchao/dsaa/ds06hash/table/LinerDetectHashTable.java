package pers.hanchao.dsaa.ds06hash.table;

/**
 * 通过线性探索解决哈希冲突的哈希表实现方式
 */
public class LinerDetectHashTable {
    //哈希表
    private Node[] hashArray;
    //初始大小
    private int capacity;
    //用量
    private int size;
    //删除数据
    private Node deletedNode;

    public LinerDetectHashTable(int capacity) {
        this.capacity = capacity;
        hashArray = new Node[capacity];
        deletedNode = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void display() {
        System.out.print("HashTable[");
        for (Node node : hashArray) {
            if (node != null) {
                System.out.print(node.toString() + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("]");
    }

    /**
     * 哈希函数
     *
     * @param key
     * @return
     */
    public int hash(int key) {
        return key % capacity;
    }

    /**
     * 插入节点
     *
     * @param node
     */
    public void insert(Node node) {
        //如果已满，则扩容和重新哈希化
        if (isFull()) {
            System.out.println("当前哈希表已满，进行扩容和重新哈希化...");
            expandHashArray();
        }
        //获取key值的哈希值
        int key = node.getKey();
        int hashValue = hash(key);
        //如果当前哈希值下标已经有值且当前节点不是删除节点时，则线性向后进行探索
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != Integer.MIN_VALUE) {
            //线性自增
            ++hashValue;
            //确保不超出数组长度
            hashValue %= capacity;
        }
        //当前节点为空节点，将节点插入
        hashArray[hashValue] = node;
        //用量自增
        size++;
    }

    /**
     * 扩容哈希表，并重新哈希化
     * 因为哈希值是根据key%capacity计算的，所以capacity发送变化之后，需要重新继续hash值计算
     */
    private void expandHashArray() {
        //原始容量
        int oldCap = capacity;
        //原始数组
        Node[] oldArray = hashArray;
        //容量翻倍
        capacity *= 2;
        //新数组
        hashArray = new Node[capacity];
        //将原来的哈希表每个节点取出，重新建哈希化
        for (int i = 0; i < oldCap; i++) {
            insert(oldArray[i]);
        }
    }

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    public Node delete(int key) {
        //如果哈希表为空，则失败
        if (isEmpty()) {
            System.out.println("哈希表为空，无法删除！");
            return null;
        }
        //获取哈希值
        int hashValue = hash(key);
        //根据哈希值查找可能的节点
        while (hashArray[hashValue] != null) {
            //如果当前节点为要删除节点，则进行逻辑删除
            //不能物理删除，因为这样可能导致后续节点无法找到
            if (hashArray[hashValue].getKey() == key) {
                //获取被删除的节点
                Node tempNode = hashArray[hashValue];
                //将被删除的节点设置为删除节点
                hashArray[hashValue] = deletedNode;
                size--;
                return tempNode;
            }
            //线性增加
            ++hashValue;
            //防止下标越界
            hashValue %= capacity;
        }
        return null;
    }

    /**
     * 查找数据
     *
     * @param key
     * @return
     */
    public Node get(int key) {
        //获取哈希值
        int hashValue = hash(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= capacity;
        }
        return null;
    }

    /**
     * <p></p>
     *
     * @author hanchao 2018/5/13 17:38
     **/
    public static void main(String[] args) {
        LinerDetectHashTable hashTable = new LinerDetectHashTable(5);
        hashTable.display();
        //插入
        hashTable.insert(new Node(1212, 12121212));
        hashTable.display();
        hashTable.insert(new Node(1314, 13141314));
        hashTable.display();
        hashTable.insert(new Node(11, 1111));
        hashTable.display();
        hashTable.insert(new Node(22, 2222));
        hashTable.display();
        hashTable.insert(new Node(33, 3333));
        hashTable.display();
        hashTable.insert(new Node(56, 5656));
        hashTable.display();
        hashTable.insert(new Node(100, 100100));
        hashTable.display();

        //查询
        System.out.println(hashTable.get(100));
        System.out.println(hashTable.get(1314));

        //删除
        System.out.println(hashTable.delete(33));
        hashTable.display();
        System.out.println(hashTable.delete(22));
        hashTable.display();
    }
}
