package pers.hanchao.dsaa.ds04linkedlist;

/**
 * <p>双端单向链表</p>
 * @author hanchao 2018/5/12 21:28
 **/
public class DoubleEndLinkedList {
    private Node head;
    /** 增加对尾节点的引用 */
    private Node tail;
    private int size;

    public DoubleEndLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * <p>链表节点</p>
     **/
    class Node {
        //节点内容
        private Object obj;
        //下一个节点
        private Node next;

        public Node(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "obj=" + obj +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 头部添加
     * @param obj
     */
    public void addHead(Object obj){
        Node node = new Node(obj);
        //如果空链表，直接将新节点作为头节点
        if (isEmpty()){
            head = node;
            //注意将尾节点执行这个节点
            tail = node;
        }else {//链表不空，正常添加
            node.next = head;
            head = node;
        }
        size ++;
    }

    /**
     * 头部删除
     * @return 被删除的节点数据
     */
    public boolean removeHead(){
        if (isEmpty()){
            return  false;
        }else {
            if (size == 1){
                head = null;
                //注意将尾节点置为null
                tail = null;
            }else {
                head = head.next;
            }
            size --;
        }
        return true;
    }

    /**
     * 尾部新增
     * @param obj
     */
    public void addTail(Object obj){
        Node node = new Node(obj);
        if (isEmpty()){
            head = node;
            //注意将尾节点执行这个节点
            tail = node;
        }else {
            //注意将尾节点的下个节点指定为这个节点
            tail.next = node;
            //注意将尾节点执行这个节点
            tail = node;
        }
        size ++;
    }

    /**
     * 打印链表
     */
    public void display(){
        System.out.print("[");
        if (isEmpty()){
            System.out.println("]");
        }else {
            Node tempNode = head;
            int tempSize = size;
            while (tempSize > 0){
                //如果不是尾节点
                if (tempNode.next != null){
                    System.out.print(tempNode.getObj() + "-->");
                    tempNode = tempNode.next;
                    tempSize --;
                }else {//如果是尾节点，则循环结束
                    System.out.println(tempNode.getObj() + "]");
                    break;
                }
            }
        }
    }
    /**
     * <p>测试</p>
     * @author hanchao 2018/5/12 21:45
     **/
    public static void main(String[] args) {
        //定义一个链表
        DoubleEndLinkedList doubleEndLinkedList = new DoubleEndLinkedList();
        doubleEndLinkedList.display();
        //插入节点
        doubleEndLinkedList.addHead("Hello World!");
        doubleEndLinkedList.display();
        doubleEndLinkedList.addTail(1324);
        doubleEndLinkedList.display();
        doubleEndLinkedList.addHead(3.1415D);
        doubleEndLinkedList.display();
        doubleEndLinkedList.addTail(true);
        doubleEndLinkedList.display();
        //移除节点
        doubleEndLinkedList.removeHead();
        doubleEndLinkedList.display();
        doubleEndLinkedList.removeHead();
        doubleEndLinkedList.display();
    }
}
