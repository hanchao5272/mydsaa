package pers.hanchao.dsaa.ds06hash.map;

/**
 * <p>有序链表</p>
 * @author hanchao 2018/5/13 19:01
 **/
public class SortedLinkedList {
    /** 头节点 */
    private Node head;

    public SortedLinkedList() {
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    /**
     * 有序插入
     * @param node
     */
    public void insert(Node node){
        int key = node.getKey();
        Node previous = null;
        Node current = head;
        //插入
        while(current != null && key > current.getKey()){
            previous = current;
            current = current.next;
        }
        //如果插入点在头节点
        if (previous == null){
            head = node;
            head.next = current;
        }else {
            node.next = current;
            previous.next = node;
        }
    }

    /**
     * 根据key删除节点
     * @param key
     */
    public void delete(int key){
        Node previous = null;
        Node current = head;
        //如果为空
        if (head == null){
            return;
        }
        //如果不是当前节点，则继续查找
        while (current != null && current.getKey() != key){
            previous = current;
            current = current.next;
        }
        //如果找到的元素时头节点
        if (previous == null){
            head = head.next;
        }else {
            previous.next = current.next;
        }
    }

    /**
     * 根据key值查找节点
     * @param key
     * @return
     */
    public Node find(int key){
        Node current = head;
        while(current != null && current.getKey() <= key){
            if (current.getKey() == key){
                return current;
            }
        }
        return null;
    }

    /**
     * 定义链表
     */
    public void display(){
        Node current = head;
        System.out.print("LinkedList[");
        while(current != null){
            System.out.print(current +  "->");
            current = current.next;
        }
        System.out.println("]");
    }

    /**
     * <p>测试</p>
     * @author hanchao 2018/5/13 20:01
     **/
    public static void main(String[] args) {
        SortedLinkedList linkedList = new SortedLinkedList();
        linkedList.display();
        //插入
        linkedList.insert(new Node(5,2));
        linkedList.display();
        linkedList.insert(new Node(2,3));
        linkedList.display();
        linkedList.insert(new Node(3,4));
        linkedList.display();
    }
}
