package pers.hanchao.dsaa.ds03queue;

import pers.hanchao.dsaa.ds04linkedlist.DoubleEndLinkedList;

/**
 * <p>通过双端单向列表实现队列</p>
 * @author hanchao 2018/5/12 22:04
 **/
public class QueueByDoubleEndLinkedList {
    private DoubleEndLinkedList linkedList;

    public QueueByDoubleEndLinkedList() {
        linkedList = new DoubleEndLinkedList();
    }

    /**
     * 队列入队=链表尾部添加
     * @param obj
     */
    public void add(Object obj){
        linkedList.addTail(obj);
    }

    /**
     * 队列出队=链表头部删除
     * @return
     */
    public Object remove(){
        return linkedList.removeHead();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void display(){
        linkedList.display();
    }

    /**
     * <p>测试由双端链表实现的队列</p>
     * @author hanchao 2018/5/12 22:08
     **/
    public static void main(String[] args) {
         QueueByDoubleEndLinkedList queue = new QueueByDoubleEndLinkedList();
         queue.display();
         //入队
        queue.add(5);
        queue.display();
        queue.add(4);
        queue.display();
        queue.add(3);
        queue.display();
        queue.add(2);
        queue.display();
        queue.add(1);
        queue.display();
        //出队
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
    }
}
