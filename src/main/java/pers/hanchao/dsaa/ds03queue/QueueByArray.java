package pers.hanchao.dsaa.ds03queue;

import java.util.Arrays;

/**
 * <p>数组实现的单向队列</p>
 *
 * @author hanchao 2018/5/12 15:13
 **/
public class QueueByArray {
    /**
     * 定义数组存放元素
     */
    private Object[] elements;
    /**
     * 容量
     */
    private int capacity;
    /**
     * 用量
     */
    private int length;
    /**
     * 头部
     */
    private int front;
    /**
     * 尾部
     */
    private int rear;

    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public QueueByArray(int capacity) {
        //初始化容量和用量
        this.capacity = capacity;
        this.length = 0;
        elements = new Object[this.capacity];
        //开始时头部为0
        front = 0;
        //开始时尾部为-1
        rear = -1;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 是否已满
     *
     * @return
     */
    public boolean isFull() {
        return length == capacity;
    }

    /**
     * 在尾部入队--处理rear指针
     */
    public void add(Object obj) {
        //如果队里已满，则不能再入队
        if (isFull()) {
            System.out.println("队列已满！");
        } else {
            //如果尾部指向了顶部，则循环回来指向-1
            if (rear == capacity - 1) {
                rear = -1;
            }
            //对位指针加1
            rear++;
            elements[rear] = obj;
            //用量加1
            length++;
        }
    }

    /**
     * 在头部出队--处理front指针
     *
     * @return
     */
    public Object remove() {
        //如果队列为空，则不能出队
        if (isEmpty()) {
            System.out.println("队列为空！");
            return null;
        } else {
            //获取对头元素
            Object obj = elements[front];
            //将对头元素设置为null
            elements[front] = null;
            //头部指针上移
            front++;
            //如果对头指针达到顶端，则循环回0
            if (front == capacity) {
                front = 0;
            }
            //用量减一
            length--;
            return obj;
        }
    }

    /**
     * 获取头部数据
     *
     * @return
     */
    public Object element() {
        return elements[front];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "QueueByArray{" +
                "elements=" + Arrays.toString(elements) +
                ", capacity=" + capacity +
                ", length=" + length +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    /**
     * <p>测试单向队列</p>
     *
     * @author hanchao 2018/5/12 16:11
     **/
    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(5);
        System.out.println(queue);
        System.out.println(queue.element());
        //入队
        queue.add("Hello World!");
        System.out.println(queue);
        queue.add(1314);
        System.out.println(queue);
        queue.add(3.14F);
        System.out.println(queue);
        queue.add(20.1D);
        queue.add(true);
        System.out.println(queue);
        queue.add(1);
        System.out.println(queue);

        //出队
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);

        //入队
        queue.add("David");
        System.out.println(queue);
        queue.add("Joker");
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
