package pers.hanchao.dsaa.ds04linkedlist;

/**
 * <p>双向链表</p>
 * @author hanchao 2018/5/12 22:58
 **/
public class TwoWayLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 在头部添加节点
     * @param obj
     */
    public void addHead(Object obj){
        Node node = new Node(obj);
        //空
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            //将当前头节点的前指针指向新节点
            head.prev = node;
            //将新节点的后指针指向头节点
            node.next = head;
            //将新节点设置此新的头节点
            head = node;
        }
        size ++;
    }

    /**
     * 在尾部添加节点
     * @param obj
     */
    public void addTail(Object obj){
        Node node = new Node(obj);
        //空
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            //将当前节点的头指针指向尾节点
            node.prev = tail;
            //将尾节点的尾指针指向当前节点
            tail.next = node;
            //将当前节点设置为新的尾节点
            tail = node;
        }
        size ++;
    }

    /**
     * 在头部删除节点
     * @return
     */
    public Object deleteHead(){
        Node node = null;
        if (isEmpty()){
            return null;
        }else {
            //获取头节点
            node = head;
            //将当前头节设置为下一个节点
            head = head.next;
            //将当前头节点的前指针指向null
            head.prev = null;
        }
        size --;
        return node.getObj();
    }

    /**
     * 在尾部删除节点
     * @return
     */
    public Object deleteTail(){
        Node node = null;
        if (isEmpty()){
            return null;
        }else {
            //获取尾节点
            node = tail;
            //将当前尾节点的上一个节点设置为尾节点
            tail = tail.prev;
            //将新的尾节点的后指针指向null
            tail.next = null;
        }
        size --;
        return node.getObj();
    }

    /**
     * 展示
     */
    public void display(){
        System.out.print("[");
        if(isEmpty()){
            System.out.println("]");
        }else {
            Node tempNode = head;
            int tempSize = size;
            while(tempSize > 0){
                if (tempNode.next == null){
                    System.out.println(tempNode.getObj() + "]");
                    break;
                }else {
                    System.out.print(tempNode.getObj() + "<-->");
                    tempNode = tempNode.next;
                    tempSize -- ;
                }
            }
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
     * 双向节点
     */
    class Node{
        private Object obj;
        private Node prev;
        private Node next;

        public Node(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "obj=" + obj +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
    /**
     * <p>测试双向链表</p>
     * @author hanchao 2018/5/12 23:15
     **/
    public static void main(String[] args) {
         TwoWayLinkedList linkedList = new TwoWayLinkedList();
         linkedList.display();
         //入队
        linkedList.addHead(5);
        linkedList.display();
        linkedList.addHead(4);
        linkedList.display();
        linkedList.addHead(3);
        linkedList.display();
        linkedList.addHead(2);
        linkedList.display();
        linkedList.addHead(1);
        linkedList.display();
        linkedList.addTail("Hello");
        linkedList.display();
        linkedList.addTail("The");
        linkedList.display();
        linkedList.addTail("World");
        linkedList.display();
        linkedList.addTail("is");
        linkedList.display();
        linkedList.addTail("Good");
        linkedList.display();
        //出队
        System.out.print(linkedList.deleteHead() + " ");
        System.out.print(linkedList.deleteHead() + " ");
        System.out.print(linkedList.deleteHead() + " ");
        System.out.print(linkedList.deleteTail() + " ");
        System.out.print(linkedList.deleteTail() + " ");
        System.out.print(linkedList.deleteTail() + " ");

    }
}
