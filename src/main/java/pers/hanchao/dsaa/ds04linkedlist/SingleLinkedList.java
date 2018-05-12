package pers.hanchao.dsaa.ds04linkedlist;

/**
 * <p>单链表</p>
 *
 * @author hanchao 2018/5/12 18:08
 **/
public class SingleLinkedList {
    /**
     * 头节点
     **/
    private Node head;
    /**
     * 链表长度
     **/
    private int size;

    public SingleLinkedList() {
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
     * 在头节点处添加新节点
     */
    public void addHead(Object data) {
        Node node = new Node(data);
        //如果链表为空，则将当前节点设置为头节点
        if (isEmpty()) {
            head = node;
        } else {//如果链表不为空
            //将新节点的next指向当前头节点
            node.next = head;
            //将当前节点设置为新节点
            head = node;
        }
        size++;
    }

    /**
     * 删除头节点
     *
     * @Return 头节点的数据
     */
    public Object removeHead() {
        //如果列表为空，则不能删除
        if (isEmpty()) {
            System.out.println("链表为空，无法删除头节点！");
            return null;
        }
        //获取头节点数据
        Object obj = head.getObj();
        //去除head节点的下一个节点
        Node next = head.next;
        //删除头节点
        head = null;
        //将当前节点的下一个节点作为head节点
        head = next;
        //有效长度自减
        size--;
        return obj;
    }

    /**
     * 查询指定的节点
     *
     * @param obj 节点值
     * @return 节点
     */
    public Node find(Object obj) {
        //定义一个节点指向头节点
        Node node = head;
        //定义一个大小用于查找
        int tempSize = size;
        //遍历所有节点进行查找
        while (tempSize > 0) {
            //如果找到，就停止循环
            if (obj.equals(node.getObj())) {
                return node;
            } else {
                //如果没找到，就切换至下一个节点继续查找
                node = node.next;
                tempSize--;
            }
        }
        return null;
    }

    /**
     * 删除指定的节点
     *
     * @param obj 节点数据
     * @return 是否删除成功
     */
    public boolean remove(Object obj) {
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
            if (obj.equals(node.getObj())) {
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
        System.out.print("SingleLinkedList[");
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
                    System.out.print(tempNode.getObj() + "-->");
                } else {
                    System.out.println(tempNode.getObj() + "]");
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
     * <p></p>
     *
     * @author hanchao 2018/5/12 18:12
     **/
    public static void main(String[] args) {
        //定义一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.display();
        //插入节点
        singleLinkedList.addHead("Hello World!");
        singleLinkedList.display();
        singleLinkedList.addHead(1324);
        singleLinkedList.display();
        singleLinkedList.addHead(3.1415D);
        singleLinkedList.display();
        singleLinkedList.addHead(true);
        singleLinkedList.display();
        //移除节点
        singleLinkedList.remove(1324);
        singleLinkedList.display();
        singleLinkedList.removeHead();
        singleLinkedList.display();
    }
}
