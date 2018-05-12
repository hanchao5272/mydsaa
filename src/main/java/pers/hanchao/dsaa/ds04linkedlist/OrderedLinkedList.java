package pers.hanchao.dsaa.ds04linkedlist;

/**
 * <p>有序链表</p>
 * @author hanchao 2018/5/12 22:25
 **/
public class OrderedLinkedList {
    /**
     * 头节点
     **/
    private Node head;
    /**
     * 链表长度
     **/
    private int size;

    public OrderedLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加新节点
     * 遵循从大到小的顺序
     */
    public void add(int priority) {
        //定义新节点值
        Node node = new Node(priority);
        //如果链表为空，则将当前节点设置为头节点
        if (isEmpty()) {
            head = node;
        } else {//如果链表不为空
            //定义临时节点
            Node tempNode = head;
            //定义临时节点的上一个节点
            Node previous = null;
            //定义临时大小
            int tempSize = size;
            //遍历
            while(tempSize > 0){
                //如果临时节点优先级大于新节点，则新节点向后移动
                if (tempNode.getPriority() > node.getPriority()){
                    previous = tempNode;
                    tempNode = tempNode.next;
                    tempSize --;
                }else {
                    break;
                }
            }
            //如果只有一个节点,且这个节点小于新节点，则交换两个节点
            if (previous == null){
                head = node;
                head.next = tempNode;
            }else {//如果不止一个节点，则将新节点插入
                previous.next = node;
                node.next = tempNode;
            }
        }
        size ++;
    }

    /**
     * 删除头节点
     *
     * @Return 头节点的数据
     */
    public int removeHead() {
        //如果列表为空，则不能删除
        if (isEmpty()) {
            System.out.println("链表为空，无法删除头节点！");
            return Integer.MIN_VALUE;
        }
        //获取头节点数据
        int priority = head.getPriority();
        //去除head节点的下一个节点
        Node next = head.next;
        //删除头节点
        head = null;
        //将当前节点的下一个节点作为head节点
        head = next;
        //有效长度自减
        size--;
        return priority;
    }

    /**
     * 删除指定的节点
     *
     * @param priority 节点数据
     * @return 是否删除成功
     */
    public boolean remove(int priority) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！");
            return false;
        }
        //定义一个节点用于查找节点
        Node node = head;
        //定义一个节点用于存放查找节点的上一个节点
        Node previous = head;
        //定义一个临时长度用于查找
        int tempSize = size;
        //循环遍历
        while (tempSize > 0) {
            //如果找到节点，则删除
            if (priority == node.getPriority()) {
                //如果当前节点为头节点，则将头节点设置为下一个节点
                if (node == head) {
                    head = head.next;
                } else {//如果当前节点不是头节点
                    //将上一个节点的next指向当前节点的下一个节点
                    previous.next = node.next;
                    //删除当前节点
                    node = null;
                }
                break;
            } else {//找不到节点，则继续向下走
                //将当前节点设置为上一个节点
                previous = node;
                //将下一个节点设置为当前节点
                node = node.next;
            }
        }
        size --;
        return true;
    }

    /**
     * 打印所有节点
     */
    public void display() {
        System.out.print("OrderedLinkedList[");
        //如果为空，则直接打印null
        if (isEmpty()) {
            System.out.println("]");
        } else {
            Node tempNode = head;
            int tempSize = size;
            //循环打印
            while (tempSize > 0) {
                //如果当前节点不是尾节点
                if (tempNode.next != null) {
                    System.out.print(tempNode.getPriority() + "-->");
                } else {
                    System.out.println(tempNode.getPriority() + "]");
                    break;
                }
                tempNode = tempNode.next;
                tempSize--;
            }
        }
    }

    /**
     * <p>链表节点</p>
     **/
    class Node {
        //节点内容
        private int priority;
        //下一个节点
        private Node next;

        public Node(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
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
                    "priority=" + priority +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * <p></p>
     *
     * @author hanchao 2018/5/12 18:12
     **/
    public static void main(String[] args) {
        //定义一个链表
        OrderedLinkedList OrderedLinkedList = new OrderedLinkedList();
        OrderedLinkedList.display();
        //插入节点
        OrderedLinkedList.add(12);
        OrderedLinkedList.display();
        OrderedLinkedList.add(5);
        OrderedLinkedList.display();
        OrderedLinkedList.add(7);
        OrderedLinkedList.display();
        OrderedLinkedList.add(10);
        OrderedLinkedList.display();
        OrderedLinkedList.add(2);
        OrderedLinkedList.display();
        //移除节点
        OrderedLinkedList.remove(10);
        OrderedLinkedList.display();
        OrderedLinkedList.removeHead();
        OrderedLinkedList.display();
    }
}
