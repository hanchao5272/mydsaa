package pers.hanchao.dsaa.ds02stack;

import pers.hanchao.dsaa.ds04linkedlist.OneWayLinkedList;

/**
 * <p>通过单向链表实现栈</p>
 * @author hanchao 2018/5/12 21:55
 **/
public class StackByOneWayLinkedList {
    private OneWayLinkedList linkedList;

    public StackByOneWayLinkedList() {
        linkedList = new OneWayLinkedList();
    }

    /**
     * 入栈=队列头部入队
     * @param obj
     */
    public void push(Object obj){
        linkedList.addHead(obj);
    }

    /**
     * 出栈=队列头部出队
     * @return
     */
    public Object pop(){
        return linkedList.removeHead();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    /**
     * 打印信息
     */
    public void display(){
        linkedList.display();
    }

    /**
     * <p>测试由单向链表实现的栈</p>
     * @author hanchao 2018/5/12 22:01
     **/
    public static void main(String[] args) {
         StackByOneWayLinkedList stack = new StackByOneWayLinkedList();
         stack.display();
         //入栈
        stack.push(5);
        stack.display();
        stack.push(4);
        stack.display();
        stack.push(3);
        stack.display();
        stack.push(2);
        stack.display();
        stack.push(1);
        stack.display();

        //出栈
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
    }
}
